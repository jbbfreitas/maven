
# Criando projeto Java com Maven

Este guia ajuda você a usar o Maven para criar um projeto Java simples.
O que você vai construir:

Você criará um aplicativo que fornece a hora do dia e, em seguida, o cria com o Maven.

### O que você precisará
 - 15 minutes

 - Eclipse

 - JDK 8
 

### Como completar este guia

#### Configurar o projeto

Primeiro, você precisa configurar um projeto Java para o Maven. Para manter o foco no Maven, torne o projeto o mais simples possível por enquanto. Crie essa estrutura em uma pasta de projeto de sua escolha.
Crie a estrutura de diretórios

No diretoria GrupoDeEstudo/Maven/PrimoMave, crie a seguinte estrutura de subdiretórios: 


> mkdir -p src/main/java/hello

 em sistemas * nix:

└── src
    └── main
        └── java
            └── hello

Dentro da pasta `src/main/java/hello` , você pode criar qualquer classe java. 

Para manter a consistência desse guia, crie duas classes: `HelloWorld.java` and `Greeter.java` .


```
package br.com.abim.main;

public class HelloWorld {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
    }
}

```

```java
package br.com.abim.domain;

public class Greeter {
    public String sayHello() {
        return "Hello world!";
    }
}
```

#### Instalar e testar o Maven



