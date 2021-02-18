package jp.techacademy.ryoichi.satoyama.sampleproject

data class User(val id: Long, val name: String) {
    override fun toString(): String {
        return name
    }
}