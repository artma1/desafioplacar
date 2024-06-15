# Desafio Placar

O projeto é uma prova técnica que pede a criação de uma API para auxiliar no cálculo de combinações possíveis do placar em uma partida de futebol americano. A prova pode ser consultada <a href="Enunciado Backend-05_2024.pdf"> aqui</a>.

## Instruções de Utilização
### Através de IDE
O usuário deverá iniciar o Servidor.

Então podera executar o <a href="src/main/java/com/example/testeSol/envioScore.java"> Envio do placar</a> no terminal com command line arguments representando o placar. Ex: java envioScore.java 15x3 

O programa exibirá alguns cálculos na tela para facilitar checagem, e enviará o JSON para início do procedimento na API REST desenvolvida.
### Por docker
<li> 1- Comando no terminal: docker pull arturma30/studiosoldesafio:latest</li>
<li> 2- Rodar o container</li>
<li> 3- O servidor se inicializa ao rodar o container</li>
<li> 4- Abrir o terminal no container e usar o comando: java envioScore.java 15x3</li>

O usuário pode testar com o placar de preferência, usando o formato 'int'x'int'.
O resultado esperado será entregue no log, junto com a impressão de parte do cálculo ilustrando a solução.

## Artefatos
Os seguintes artefatos são o código fonte com a solução do problema:

<li><a href="src/main/java/com/example/testeSol/TesteSolApplication.java
"> Servidor</a></li>

<li><a href="src/main/java/com/example/testeSol/ScoreService.java"> Cálculo do Resultado</a></li>

<li><a href="src/main/java/com/example/testeSol/ScoreController.java"> Integração com Servidor</a></li>

 <li><a href="src/main/java/com/example/testeSol/envioScore.java"> Envio do placar</a></li>
      
