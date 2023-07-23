import scala.io.StdIn

object CaesarCipher {
  def encrypt(text: String, shift: Int): String = {
    val normalizedShift = shift % 26
    text.map { char =>
      if (char.isLetter) {
        val baseChar = if (char.isUpper) 'A' else 'a'
        ((char - baseChar + normalizedShift) % 26 + baseChar).toChar
      } else {
        char
      }
    }
  }

  def decrypt(ciphertext: String, shift: Int): String = {
    encrypt(ciphertext, -shift)
  }

  def cipher(text: String, shift: Int, func: (String, Int) => String): String = {
    func(text, shift)
  }

  def main(args: Array[String]): Unit = {
    printf("Enter a string: ")
    val inputText = StdIn.readLine()

    printf("Enter a number for the shift: ")
    val shiftAmount = StdIn.readInt()

    val decryptedText = cipher(encryptedText, shiftAmount, decrypt)
    println(s"Decrypted: $decryptedText")

    val encryptedText = cipher(inputText, shiftAmount, encrypt)
    println(s"Encrypted: $encryptedText")

  }
}
