enum class Nivel(val fatorXp: Int, val descricao: String) {
    BASICO(10, "Ideal para iniciantes"),
    INTERMEDIARIO(50, "Para quem já tem base"),
    DIFICIL(100, "Desafios complexos")
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Usuario(val nome: String) {
    var xpTotal: Int = 0
        private set

    fun ganharXp(pontos: Int) {
        xpTotal += pontos
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("ERRO: O aluno ${usuario.nome} já está matriculado em $nome.")
            return
        }

        inscritos.add(usuario)
        
        // XP do nível * QTD de conteúdo
        val xpGanho = nivel.fatorXp * conteudos.size
        usuario.ganharXp(xpGanho)

        println("SUCESSO: ${usuario.nome} matriculado em $nome.")
        println("   -> XP Ganho: +$xpGanho (Total: ${usuario.xpTotal})")
    }
    
    fun mostrarInscritos() {
        println("Alunos matriculados em $nome:")
        inscritos.forEach { println(it.nome) }
        println("-----")
	}
}

infix fun Usuario.matriculouEm(formacao: Formacao) {
    formacao.matricular(this)
}

fun main() {
    val conteudosBasicos = listOf(
        ConteudoEducacional("Variáveis", 30),
        ConteudoEducacional("Funções", 45)
    )
    
    val conteudosAvancados = listOf(
        ConteudoEducacional("Coroutines", 120),
        ConteudoEducacional("Flows", 100),
        ConteudoEducacional("Clean Architecture", 180)
    )

    val formacaoBasica = Formacao("Kotlin Start", conteudosBasicos, Nivel.BASICO)
    val formacaoPro = Formacao("Kotlin Master", conteudosAvancados, Nivel.DIFICIL)

    val aluno = Usuario("User1")
    val aluno2 = Usuario("User2")

    println("--- Cenário 1: Sintaxe Infix (Leitura natural) ---")
    aluno matriculouEm formacaoBasica
    
    println("\n--- Cenário 2: Acúmulo de XP ---")
    aluno matriculouEm formacaoPro

    println("\n--- Cenário 3: Tentativa de Matrícula Dupla ---")
    aluno matriculouEm formacaoPro
    
    println("\n--- Cenário 4: Outro usuário ---")
    aluno2 matriculouEm formacaoBasica

    println("\n--- Resumo Final ---")
    println("XP Final do ${aluno.nome}: ${aluno.xpTotal}")
    println("XP Final do ${aluno2.nome}: ${aluno2.xpTotal}")
    
    println("-----")
    formacaoBasica.mostrarInscritos()
    formacaoPro.mostrarInscritos()
}