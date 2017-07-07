# Sistema de Mapeamento de Habilidades
### LCP Integral 2017

- Desenvolvido utilizando NetBeans 8.2 e GlassFish Server 4.1.1

# Grupo:
- Guilherme Guiguer Menaldo
- Jhenifer Marques dos Santos
- Raphael Espindola Trench

# Instalação
1. Importe o modelo de banco de dados para o MySQL
2. Altere as configurações do banco de dados no arquivo IMySQL (br.unesp.rc.habilidades.util)
3. Conecte-se ao banco de dados por um gerenciador
4. Na tabela Acesso adicione um usuario e senha (será usado para a conta de administrador)
5. Na tabela Cargo adicione um novo cargo com a seguinte linha de permissão:
	GERENCIAR_CARGOS,GERENCIAR_PROJETOS,GERENCIAR_HABILIDADES,GERENCIAR_MEMBROS
e campo "ativo" igual a 1
6. Na tabela Membro adicione um novo cadastro tendo ativo = 1, Acesso_idAcesso sendo o id criado na tabela acesso e Cargo_idCargo sendo o id criado na tabela Cargo.
7. Inicie o sistema no NetBeans e faça login com sua conta de Administrador.