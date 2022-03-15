## JDBC

Repositório referente a estudos básicos relacionados ao Java Database Connectivity.

## Comandos Básicos

- `Delete`: DELETE FROM table_name WHERE condition;
- `Insert`: INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);
- `Select`: SELECT * FROM table_name;

## Por que utilizar o PreparedStatement ao invés do Statement?

O uso do Statement permite que o usuário insira caracteres que podem causar bugs. Como por exemplo, caso o usuário insira uma aspa simples, a requisição será quebrada, gerando um erro. Além de gerar erros, permite que usuários mal intencionados manipulem o banco de dados.

Utilizando o PreparedStatement, o próprio JDBC trata esses casos, melhorando a qualidade e segurança do código.