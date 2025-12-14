# jlox-Interpreter

Uma implementação em Java do interpretador **jlox**, desenvolvida como estudo baseado no livro *Crafting Interpreters* de Robert Nystrom.  
O projeto segue a arquitetura de um **tree-walk interpreter**, acompanhando fielmente a evolução apresentada no livro **até o Capítulo 12 (Classes)**, com pequenas variações estruturais próprias do desenvolvimento incremental.

---

## 📌 Sumário

- [Sobre o Projeto](#sobre-o-projeto)
- [Status de Implementação (Capítulos)](#status-de-implementação-capítulos)
- [Funcionalidades Implementadas](#funcionalidades-implementadas)
- [Requisitos](#requisitos)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Autores](#autores)
- [Referências](#referências)

---

## Sobre o Projeto

O objetivo deste repositório é implementar, passo a passo, um interpretador completo para a linguagem **Lox**, conforme descrito na **Parte I** do livro *Crafting Interpreters*.  

A implementação tem caráter **educacional**, focando em:

- processamento de linguagens de programação;
- construção de interpretadores;
- análise léxica e sintática;
- execução baseada em **AST (Abstract Syntax Tree)**;
- escopo léxico estático;
- funções, closures e classes.

O código foi escrito de forma incremental, acompanhando a progressão dos capítulos do livro e preservando a separação clara de responsabilidades entre **Parser**, **Resolver**, **Interpreter** e **Environment**.

---

## 📚 Status de Implementação (Capítulos)

| Capítulo | Conteúdo | Status |
|--------|---------|--------|
| 4–6 | Scanner (Lexing) | ✔ Implementado |
| 7 | Avaliação de expressões | ✔ Implementado |
| 8 | Statements e estado | ✔ Implementado |
| 9 | Controle de fluxo | ✔ Implementado |
| 10 | Funções | ✔ Implementado |
| 11 | Resolução de escopo (Resolver) | ✔ Implementado |
| 12 | Classes e instâncias (`this`, `init`) | ✔ Implementado |

---

## Funcionalidades Implementadas

### ✔ Lexing (Scanner)
- Tokenização de números, strings, identificadores, operadores e símbolos.
- Suporte a comentários de linha.
- Detecção e relatório de erros léxicos.

---

### ✔ Parsing (Parser)
- Construção da AST usando **recursive descent parsing**.
- Precedência correta de operadores.
- Mensagens de erro sintático com sincronização.

---

### ✔ Execução (Interpreter)

- Tipos suportados:
  - `Double`, `String`, `Boolean` e `nil`.
- Operadores aritméticos, relacionais e lógicos.
- Controle de fluxo:
  - `if / else`
  - `while`
  - `for` (dessugar para `while`).
- Declarações e atribuições de variáveis.
- Funções como cidadãos de primeira classe.
- **Closures** com escopo léxico.
- Retorno de funções via exceção controlada (`Return`).

---

### ✔ Classes (até Capítulo 12)

- Declaração de classes.
- Instâncias (`LoxInstance`).
- Métodos.
- Construtores (`init`).
- Palavra-chave `this`.
- Binding correto de métodos ao objeto.

---

### ✔ Resolução de Escopo (Resolver)

- Análise estática antes da execução.
- Escopo léxico com profundidade calculada.
- Detecção de:
  - leitura de variável em seu próprio inicializador;
  - retorno fora de funções;
  - retorno com valor em `init`.
- Tratamento correto de `this` dentro de classes.

---

### ✔ Infraestrutura

- **Visitor Pattern** para AST.
- Separação clara de responsabilidades:
  - `Parser` → constrói AST
  - `Resolver` → resolve escopos
  - `Interpreter` → executa AST
  - `Environment` → mantém estados e encadeamento léxico
- Geração automática das classes de AST via `GenerateAst.java`.

---

## Requisitos

- Java JDK 8+.
- Terminal (bash, zsh ou PowerShell).
- Ambiente de desenvolvimento Java (VS Code, IntelliJ ou similar).

---

## Estrutura do Projeto

```
src/
└── com/
    └── craftinginterpreters/
        ├── lox/
        │   ├── Lox.java              # Ponto de entrada
        │   ├── Scanner.java          # Analisador léxico
        │   ├── Parser.java           # Analisador sintático
        │   ├── Expr.java             # AST de expressões
        │   ├── Stmt.java             # AST de declarações
        │   ├── Interpreter.java      # Execução da AST
        │   ├── Environment.java      # Escopos e variáveis
        │   ├── Resolver.java         # Resolução estática de escopo
        │   ├── LoxCallable.java      # Interface de chamadas
        │   ├── LoxFunction.java      # Funções e métodos
        │   ├── LoxClass.java         # Classes
        │   └── LoxInstance.java      # Instâncias
        └── tool/
            └── GenerateAst.java      # Gerador da AST
README.md
```

---

## Autores

- **Alisson Emanuel Diniz Santos**  
- **Pacelle Henrique Parnaíba Sobral**

---

## Referências

- Nystrom, Robert. *Crafting Interpreters*.  
- Site oficial do livro e repositório de apoio.  
- Implementações educacionais da comunidade.
