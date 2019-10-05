package org.discusinstitute.greentaskandroid.vendor.blauhaus


val REQUIRES_NUMBERS        = 0b00000001
val REQUIRES_LC_LETTERS     = 0b00000010
val REQUIRES_UC_LETTERS     = 0b00000100
val REQUIRES_SPECIAL_CHARS  = 0b00001000
val DEFAULT = REQUIRES_LC_LETTERS or REQUIRES_NUMBERS or
        REQUIRES_UC_LETTERS or REQUIRES_SPECIAL_CHARS

fun testPassword(pw:String, minLength:Int = 8, mode:Int = DEFAULT):String? {
    var tests = mutableListOf<String?>()
    tests.add(isCorrectLength(minLength, pw))
    if (mode and REQUIRES_NUMBERS == REQUIRES_NUMBERS) {
        tests.add(containsNumbers(pw))
    }
    if (mode and REQUIRES_LC_LETTERS == REQUIRES_LC_LETTERS) {
        tests.add(containsLowerCaseLetters(pw))
    }
    if (mode and REQUIRES_UC_LETTERS == REQUIRES_UC_LETTERS) {
        tests.add(containsUpperCaseLetters(pw))
    }
    if (mode and REQUIRES_SPECIAL_CHARS == REQUIRES_SPECIAL_CHARS) {
        tests.add(containsSpecialCharacters(pw))
    }

    if (tests.filterNotNull().isEmpty()) {
        return null
    } else {
        var sb = StringBuilder()
        sb.append("Password must: ")
        sb.append(tests.filterNotNull().joinToString(", "))
        return sb.toString()
    }
}


fun containsNumbers(pw: String):String? {
    if ("[0-9]".toRegex().containsMatchIn(pw)) {
        return null
    } else {
        return "contain a number"
    }
}

fun containsSpecialCharacters(pw:String):String? {
    if ("[!@#\\\$%\\^&]".toRegex().containsMatchIn(pw)) {
        return null
    } else {
        return "contain a special character"
    }
}

fun containsLowerCaseLetters(pw: String):String? {
    if ("[a-z]".toRegex().containsMatchIn(pw)) {
        return null
    } else {
        return "contain a lowercase letter"
    }
}

fun containsUpperCaseLetters(pw: String):String? {
    if ("[A-Z]".toRegex().containsMatchIn(pw)) {
        return null
    } else {
        return "contain an uppercase letter"
    }
}

fun isCorrectLength(min: Int, pw: String):String? {
    if (pw.length >= min) {
        return null
    } else {
        return "be at least ${min} characters"
    }
}