# jlox-Interpreter

Uma implementação em Java do interpretador **jlox**, desenvolvida como estudo baseado no livro *Crafting Interpreters* de Robert Nystrom.  
O projeto segue a arquitetura de um **tree-walk interpreter**, abordando desde o scanner e parser até resolução de variáveis, funções, classes e execução dinâmica.

---

## 📌 Sumário

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades Implementadas](#funcionalidades-implementadas)
- [Requisitos](#requisitos)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Autores](#autores)
- [Referências](#referências)

---

## Sobre o Projeto

O objetivo deste repositório é implementar, passo a passo, um interpretador completo para a linguagem **Lox**, acompanhando a primeira parte do livro *Crafting Interpreters*.  
A implementação é educativa e visa ilustrar:

- processamento de linguagens,
- construção de interpretadores,
- análise sintática,
- execução baseada em AST,
- escopo estático e dinâmico,
- funções, closures, classes e herança.

---

## Funcionalidades Implementadas

### ✔ Lexing (Scanner)
- Tokenização de números, strings, identificadores, operadores e símbolos.
- Suporte a comentários.
- Detecção de erros léxicos.

### ✔ Parsing (Parser)
- Construção da AST usando *recursive descent parsing*.
- Mensagens de erro amigáveis para sintaxe incorreta.

### ✔ Execução (Interpreter)
- Tipos: números, strings, booleanos e `nil`.
- Operadores aritméticos e lógicos.
- Controle de fluxo:  
  `if`, `else`, `while`, e dessugar de `for`.
- Declarações e atribuições de variáveis.
- Funções de primeira classe (closures).
- Classes, herança, `this` e `super`.
- Resolução de variáveis com escopo léxico estático.

### ✔ Infraestrutura
- Visitor Pattern para AST.
- Resolvedor de escopos antes da execução.
- Geração automática das classes de AST.

## Requisitos
- Java JDK 8+ (ou versão usada no seu projeto).
- Terminal/bash/PowerShell para execução.

## Estrutura do Projeto

src/
  com/
    craftinginterpreters/
      lox/
        Lox.java              # Ponto de entrada
        Scanner.java          # Lexer
        Parser.java           # Parser
        Expr.java             # AST para expressões
        Stmt.java             # AST para declarações
        Interpreter.java      # Executa a AST
        Environment.java      # Escopo/variáveis
        Resolver.java         # Análise estática de escopo
      tool/
        GenerateAst.java      # Gera classes da AST
README.md

## Autores

- Alisson Emanuel Diniz Santos
- Pacelle Henrique Parnaíba Sobral

## Referências

- Crafting Interpreters – Robert Nystrom.
- Repositório oficial e site do livro.
- Implementações educacionais da comunidade.
