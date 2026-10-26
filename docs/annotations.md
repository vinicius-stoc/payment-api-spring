Por que um DTO de criação não deveria necessariamente possuir os mesmos campos da Entity?


DTO (Data Transfer Object): 
O que é: O DTO é uma classe simples cuja unica finalizade é transportar dados entre o mundo externo
(como a tela de um aplicativo ou uma requisição de API) e a logica interna do sistema. 
Pra que serve: Serve como um contrato formatado para o que uma tela ou cliente precisa enviar ou receber
Como usei no projeto: A primeiro momento utilizei DTO apenas para definir o que a API precisa receber.

Entity: 
O que é: Representação direta das tabelas do banco de dados ou das regras de negocio centrais da aplicação
Para que serve: Reflete exatamente como os os são armazenados de forma persistente
Como usei no projeto: Utilizei o entity para definir como os dados serão armazenados no meu DB, a maior diferença entre
meu Entity e minha DTO é que a geração de ID acontece apenas no Entity, o usuario nao deve ser responsavel por criar ID
isso é feito automaticamente pelo sistema


Por que converter um para o outro: 
- Segurança: Se retornar a Entity para um User direto na API, pode acabar expondo o HASH de senha ou dados privados, a
DTO expoe apenas o que for permitido.
- Desacoplamento: Se alterar o nome de uma coluna no banco a Entity tambem muda. Sem a DTO isso quebraria a aplicação do
cliente. 
- Otimização: Para criar um novo registro o cliente nao sabe qual será o ID. Exigir a Entity nesse caso força o envio de
campos nulos

Fluxo de Utilização:
1 - Requisição (POST /usuarios): O cliente envia dados brutos → O sistema recebe como um DTO de entrada.
2 - Processamento: O sistema valida esse DTO e o converte para uma Entity.
3 - Persistência: A Entity é salva com sucesso no banco de dados.
4 - Resposta: O sistema busca a Entity atualizada do banco, converte para um DTO de saída (omitindo dados sensíveis) e devolve para o cliente