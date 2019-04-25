
package com.example.dietaapp

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CreateAccountActivity : AppCompatActivity() {

    // user elements declare

    private var etFirstName: EditText? = null
    private var etLastName: EditText? = null
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var btnCreateAccount: Button? = null
    private var mProgressBar: ProgressDialog? = null

    // BD references

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    private val TAG = "CreateAccountActivity"

    // global var

    private var firstName: String? = null
    private var lastName: String? = null
    private var email: String? = null
    private var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        initialise()
    }

    private fun initialise() {
        etFirstName = findViewById(R.id.et_first_name) as EditText
        etLastName = findViewById(R.id.et_last_name) as EditText
        etEmail = findViewById(R.id.et_email) as EditText
        etPassword = findViewById(R.id.et_password) as EditText
        btnCreateAccount = findViewById<Button>(R.id.btn_register) as Button
        mProgressBar = ProgressDialog(this)

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Users")
        mAuth = FirebaseAuth.getInstance()

        btnCreateAccount!!.setOnClickListener{ createNewAccount()}

    }

    private fun createNewAccount() {

        firstName = etFirstName?.text.toString()
        lastName = etLastName?.text.toString()
        email = etEmail?.text.toString()
        password = etPassword?.text.toString()

        if (!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){


            Toast.makeText(this, "Campos preenchidos corretamente", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@CreateAccountActivity, LoginActivity::class.java))

        } else {
            Toast.makeText(this, "Entre com mais informacoes", Toast.LENGTH_SHORT).show()
        }

        mProgressBar!!.setMessage("Registrando Usuario...")
        mProgressBar!!.show()

        mAuth!!
            .createUserWithEmailAndPassword(email!!, password!!).addOnCompleteListener(this){task ->
                mProgressBar!!.hide()

                if (task.isSuccessful){
                    Log.d(TAG,"CreateUserWithEmail:Sucess")

                    val userId = mAuth!!.currentUser!!.uid
                    // verificar email
                    verifyEmail();

                    val currentUserDb = mDatabaseReference!!.child(userId)
                    currentUserDb.child("fisrtName").setValue(firstName)
                    currentUserDb.child("lastName").setValue(lastName)
                    // att info bd
                    updateUserInfoandUi()
                } else{
                    Log.w(TAG,"CreateUserWithEmail:Failure", task.exception)
                    Toast.makeText(this@CreateAccountActivity, "Autenticacao falhou", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun updateUserInfoandUi (){
        //inicia nova atv
        val intent = Intent(this@CreateAccountActivity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun verifyEmail(){
        val mUser = mAuth!!.currentUser;
        mUser!!.sendEmailVerification().addOnCompleteListener(this){
            task ->

            if (task.isSuccessful){
                Toast.makeText(this@CreateAccountActivity, "Verification email sent to" + mUser.getEmail(),
                    Toast.LENGTH_SHORT).show()
            } else {
                Log.e(TAG, "SendEmailVerification", task.exception)
                Toast.makeText(this@CreateAccountActivity, "Failed to send Verification Email",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }



}
