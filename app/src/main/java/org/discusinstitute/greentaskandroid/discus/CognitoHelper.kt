package org.discusinstitute.greentaskandroid.discus

import android.content.Context
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool
import com.amazonaws.regions.Regions


val userPoolId = "us-east-1_XxHueGoQd"
val clientId = "3i1pvhcvgj7fpnojonhnshc1vi"
val clientSecret = "1tsljhkd2lhpg2cajd8ta141pij1534dk8tn685irq7nkh7du5g5"
val cognitoRegion = Regions.US_EAST_1

/* Create a CognitoUserPool instance */
fun userPool(context:Context): CognitoUserPool {
    return CognitoUserPool(context, userPoolId, clientId, clientSecret, cognitoRegion)
}

fun userAttributes(username: String, email: String, password:String): CognitoUserAttributes {
    val userAttributes = CognitoUserAttributes()
    //these are sent in the signup request
    //userAttributes.addAttribute("username", username)
    //userAttributes.addAttribute("password", password)
    userAttributes.addAttribute("email", email)
    return userAttributes
}
