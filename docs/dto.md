DTO (Data Transfer Object):
O que é: O DTO é uma classe simples cuja unica finalizade é transportar dados entre o mundo externo
(como a tela de um aplicativo ou uma requisição de API) e a logica interna do sistema.
Pra que serve: Serve como um contrato formatado para o que uma tela ou cliente precisa enviar ou receber
Como usei no projeto: A primeiro momento utilizei DTO apenas para definir o que a API precisa receber.


DTO Request (Dados de entrada): Modela os dados que o cliente envia para o backend(geralmente via put, post ou patch).
Contém apenas os campos necessarios para execução
Exemplo: No cadastro de um usuário, o Request DTO pede nome, email e senha. O campo id ou data_cadastro


DTO Response (dados de saida): Modela os dados que o backend devolve para o cliente. Ele serve para filtrar e proteger infos.
Exemplo: Ao retornar o perfil do usuário cadastrado, o Response DTO envia o id, nome e email, mas oculta o campo senha por motivos óbvios de segurança