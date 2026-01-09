# O que fazer no sistema:

# Contexto

Você foi contratado para desenvolver um sistema em Java com Spring Boot que gerencie a agenda de consultas de uma clínica médica. O sistema deverá permitir o cadastro de médicos, pacientes e de suas consultas, além de fornecer uma listagem da agenda de todos os médicos.
 
1. Estrutura de Classes
 
Médico
id (Integer, chave primária)
nome (String)
crm (Integer)
especialidade (String)
 
Cliente
id (Integer, chave primária)
nome (String)
endereço (String)
telefone (String)
 
Consulta
id (Integer, chave primária)
dataehoraConsulta (LocalDateTime)
observacoes (String)
medico (relacionamento ManyToOne → cada consulta pertence a um médico)
paciente (relacionamento ManyToOne → cada consulta pertence a um paciente)
 
2. Funcionalidades Básicas (CRUD)
Criar, editar, excluir e listar médicos.
Criar, editar, excluir e listar pacientes.
Criar, editar, excluir e listar consultas.
 
3. Funcionalidade Especial (Agenda Completa)
Criar um endpoint que retorne a agenda completa de todos os médicos.
O retorno deve mostrar o nome do médico, sua especialidade e a lista de consultas associadas a ele.

# Como executar o sistema:
Após criar o banco de dados, com o database com o seguinte nome: bdclinica, você deve abrir o navegador e digitar: localhost:8081