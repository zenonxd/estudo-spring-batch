<p align="center">
  <img src="https://img.shields.io/static/v1?label=Spring Essential - Dev Superior&message=Estudo Spring Batch&color=8257E5&labelColor=000000" alt="estudo spring batch" />
</p>


# Objetivo

Aprenderemos a ideia dos sistemas em batch, problemas que eles querem resolver e quando podemos usar um sistema baseado 
em batch.

- O que são/quando usar e por que sistemas batch
- Características dos sistemas baseados em batch
- Introdução ao Spring Batch

# Introdução

Spring batch é um framework do Spring que permite o processamento em batch (lote).

Ele é especialmente útil para tarefas de processamento em lote (batch), como migração de dados, processamento de 
arquivos, importação e exportação de grandes conjuntos de dados, e geração de relatórios.

**Benefícios:**

Escalabilidade: Pode ser configurado para lidar com grandes volumes de dados, com suporte para paralelismo.

Controle de Erros e Logs: Possui controle de erros robusto e recomeço de tarefas interrompidas (retry).

Facilidade de Configuração: Pode ser configurado para diferentes fontes e destinos de dados, como bancos de dados, arquivos, 
etc. Ideal para tarefas automatizadas e repetitivas que lidam com muitos dados em sistemas corporativos.

# Sistema Batch

Batch = lote.

É um sistema para problemas específicos, onde precisamos quebrar um alto volume de dados em lotes para serem processados
de maneira incremental.

Esse tipo de sistema roda sem a interferência do usuário, são sistemas que agendamos a execução deles e eles executam alguma tarefa.

![img.png](img.png)

-representação de um sistema baseado em batch-

Processamento na imagem acima seria, por exemplo, uma limpeza de dados/trocar o formato do dado.

Já o resultado pode ser gerar um relatório, ou simplesmente persistir esses dados em um banco de dados ou até geração de log.

RESUMO: Chega um amontoado de dados, são quebrados em lotes, processados e temos o resultado.

## Exemplos de sistemas baseados em batch

1. Sistemas que trabalham de forma automática para enviar e-mails ou notificações

Vamos pensar numa operadora de telefone celular fazendo um envio de SMS em massa.

Teremos a leitura desses clientes no banco de dados, onde serão organizados em lotes (conjunto grande de dados/clientes).

Serão processados (verificar regra de negócio). Imagine que a promoção atenda um cliente com um nível de fidelidade 
específica? O processamento faria isso.

E depois teríamos o resultado, ele seria a ação em sí! O envio da mensagem para verificar se o cliente quer participar ou não.

2. Processamento de folha de pagamento

Um processamento de folha de pagamento, pode executar no 5 dia util do mês. Portanto, podemos agendar esse serviço 
(será baseado em batch).

Ele varrerá toda a base de dados dos funcionários e fará o processamento da folha de pagamento e então imprimí-lá 
(enviar por email, por exemplo).

## Definição Sistema Batch

É um sistema que realiza um processamento de uma quantidade finita de dados sem interação com usuário 
(diferente do sistema web) ou interrupção.

Além disso, o sistema batch precisam ter mecanismos para que se esse serviço (job) seja interrompido, ele volte a 
funcionar de onde parou.

## Por que usar processamento em Batch?

O processamento em batch (lote) é uma das formas mais eficientes para processar grandes volumes de dados.

## Sistema Batch x Sistema Web

![img_1.png](img_1.png)

### Por que os dados a serem processados não estão disponíveis em batch?

Imagine um sistema de cartão de crédito. Um usuário tem uma data onde a fatura fecha, não existe uma maneira de enviar 
essa fatura sem antes o fechamento da mesma, visto que o usuário pode ainda fazer outras compras em seu cartão, 
então não temos todos os dados necessários.

Portanto, esse sistema será executado em um momento específico.

## Quando utilizar Sistemas Batch

Seria ideal em:

1. Extração, transformação e carregamento (ETL)

Imagine um sistema que periodicamente gere um conjunto de arquivo. Esses arquivos são carregados e transformados por outro sistema.

2. Migração de dados

Migração de dado de sistema legado, por exemplo, para um novo banco de dados com o sistema compatível.

Essa migração é feita por batchs (lotes).

3. Processamento paralelo

Com o processamento paralelo conseguimos acessar vários batchs (lotes) ao mesmo tempo, de maneira concorrente e simultânea.

4. Tarefas que envolvem o processamento contínuo

Execução de um sistema 24/7. Em tese esse sistema recebe um fluxo contínuo de dados e, ao mesmo tempo, precisa processar
esses dados e fazer alguma ação (registrar no banco de dados, gerar algum relatório/parecer).

## O framework Spring Batch em sí

Inicialmente o Cobol foi a primeira linguagem a tornar-se famosa pelo processamento em Batch.

Além disso, o Spring Batch permite o processamento em lote para JVM utilizando o Spring.

## O que pensar ao trabalhar com grande volume de dados?

1. Tempo

Quanto tempo o processamento deve ser executado sem prejuízo de sistemas que dependem do processamento desse sistema?

2. Integridade

Se esse processamento falhar, como garantir a integridade desses dados? Se der algum erro, a execução precisa voltar de onde parou.

3. Execução

Será uma execução agendada? Precisa de uma interação humana para ativar?

Em geral, não teremos interação humana.

4. Monitoramento

Como acompanhar a operação do processamento?

Por sorte, o Spring Batch implementa vários desses pontos acima.

## Outras considerações ao trabalhar com Sistema Batch

1. Escalabilidade

Garante que o processamento dos dados sejam feitas dentro de uma janela de tempo, definida pela execução.

2. Disponibilidade

Se determinado dado não estiver disponível naquele momento, precisamos pensar em formas de manter o sistema funcionando.

3. Usabilidade

Sistemas em batch, assumem que não teremos uma interação humana. Precisamos pensar no job em sí, a forma que o código foi estruturado para ele executar essa tarefa.

Quantos passos ele vai executar? O que cada passo vai fazer?

# Resumo parte prática

1. Lembrar dos [tipos de sistema que usam batch](#exemplos-de-sistemas-baseados-em-batch)
2. A ideia é que se o sistema caia, volte de onde parou;
3. Os dados são processados em lotes;
2. Há um grande volume de dados;
3. É executado sem a interferência humana;
4. É muito usado para migração e integração de dados;
5. Diferente do sistema web, os dados não necessariamente estão disponíveis, [veja o motivo](#por-que-os-dados-a-serem-processados-não-estão-disponíveis-em-batch)
6. Lembrar de [quando usar Sistema Batch](#quando-utilizar-sistemas-batch)
7. [O que pensar ao trabalhar com o alto volume de dados? (tempo, integridade, execução, monitoramento)](#o-que-pensar-ao-trabalhar-com-grande-volume-de-dados)
8. [Lembrar de escalabilidade, disponibilidade e usabilidade](#outras-considerações-ao-trabalhar-com-sistema-batch)

# Parte prática

Criar um projeto com as dependências de spring batch e h2 database.

Criaremos uma classe BatchConfig dentro do pacote config.

Iremos criar um Job e um Step.

## Job

Representa um processo batch completo, composto por várias etapas (Steps).

## Step

Cada Step é uma fase do Job, onde uma tarefa específica é executada (ex.: leitura, processamento e escrita de dados).

## BatchConfig

### Job

Recebe um jobRepository e um step.

Dentro do return new JobBuilder:

O primeiro argumento é nome do job, o segundo passamos o jobRepository. 

O jobRepository é responsável por manter os metadados. Metadados permite que o Framework controle o fluxo de execução.

Damos o start no step e o build.

```java
@Configuration
public class BatchConfig {

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("job", jobRepository)
                .start(step)
                .build();
    }
}
```

### Step

Steps podem ser **tasklet** (mais simples) ou **chunk** (mais complexo e elaborado).

```java
@Configuration
public class BatchConfig {

    //metodo do job acima
    
    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
                .tasklet((StepContribution contribution, ChunkContext chunkContext) -> {
                    System.out.println("Hello, world!");
                    return RepeatStatus.FINISHED;
                }, transactionManager // gerenciador de transações (neste caso, do H2)
                ).build();
    }
}
```
