enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val userName: String, val userNumber: Int) {

    init {
        require(userNumber > 0) { "O número do usuário deve ser positivo" }
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60) {

    init {
        require(duracao > 0) { "A duração do conteúdo deve ser positiva" }
    }
}

class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario): Boolean {
        if (inscritos.contains(usuario)) {
            return false
        }

        inscritos.add(usuario)
        return true
    }

    fun listarInscritos(): List<Usuario> {
        return inscritos.toList()
    }

    fun listarConteudos(): List<ConteudoEducacional> {
        return conteudos.toList()
    }
}

fun main() {
    val student01 = Usuario("Glauber", 1)
    val student02 = Usuario("Maria", 2)

    val cEducacional01 = ConteudoEducacional("kotlin", 60)
    val cEducacional02 = ConteudoEducacional("Android Studio", 60)
    val conteudos = mutableListOf(cEducacional01, cEducacional02)
    val formacao = Formacao("Mobile com kotlin", conteudos)

    formacao.matricular(student01)
    formacao.matricular(student02)

    println(formacao)
    println("Inscritos:")
    formacao.listarInscritos().forEach { println(it) }
    println("Conteúdos:")
    formacao.listarConteudos().forEach { println(it) }
}