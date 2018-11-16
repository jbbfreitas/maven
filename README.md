
# Criando projeto Java com o Apache Maven

Este guia ajuda você a usar o Maven para criar um projeto Java simples.
O que você vai construir:

Você criará um aplicativo que fornece a hora do dia e, em seguida, o cria com o Maven.

### O que você precisará
 - 15 minutes

 - Eclipse

 - JDK 8
 

### Como completar este guia

#### Configurar o projeto

Primeiro, você precisa configurar um projeto Java para o Maven. Para manter o foco no Maven, torne o projeto o mais simples possível por enquanto. Crie a seguint estrutura de diretórios

No diretorio GrupoDeEstudo/Maven/PrimoMaven, crie a seguinte estrutura de subdiretórios: 


> mkdir -p src/main/java/br/com/abim/primo

 em sistemas * nix:
```
└── src
    └── main
        └── java
            └── br
                └──com
                   └──abim
                      └──primo
			 └──domain
                         
```  


Dentro da pasta `src/main/java/br/com/abim/primo/domain` , crie a classe  `Greeter.java`


```Java
package br.com.abim.primo.domain;

public class Greeter {
    public String sayHello() {
        return "Hello world!";
    }
}
```

```
└── src
    └── main
        └── java
            └── br
                └──com
                   └──abim
                      └──primo
			 └──main
                         
```                         

Dentro da pasta `src/main/java/br/com/abim/primo/main` , crie a classe  `HelloWorld.java`



```Java
package br.com.abim.primo.main;

import br.com.abim.primo.domain.Greeter;

public class HelloWorld {

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());
		System.out.println(greeter.showLocalTime());
		
	}
	
}
```
#### Instalar e testar o Maven


O Maven pode ser baixado como um arquivo zip em http://maven.apache.org/download.cgi. Apenas os binários são necessários, então procure pelo link para apache-maven- {version} -bin.zip ou apache-maven- {version} -bin.tar.gz.

Depois de ter baixado o arquivo zip, descompacte-o no seu computador. Em seguida, adicione a pasta bin ao seu caminho.

Para testar a instalação do Maven, execute o mvn na linha de comando:

``` mvn -v ```

```
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-17T14:33:14-04:00)
Maven home: /Users/joaobosco/dev/app/apache-maven-3_4_5_2
Java version: 1.8.0_181, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre
Default locale: pt_BR, platform encoding: UTF-8
OS name: "mac os x", version: "10.14", arch: "x86_64", family: "mac"

```

#### Definir um `build`  simples do Maven

Agora que o Maven está instalado, você precisa criar uma definição de projeto Maven. Os projetos do Maven são definidos com um arquivo XML chamado pom.xml. Entre outras coisas, esse arquivo fornece o nome, a versão e as dependências do projeto em bibliotecas externas.

Crie um arquivo chamado pom.xml na raiz do projeto (ou seja, coloque-o  na mesma pasta onde está a pasta src) e forneça o seguinte conteúdo:

``` pom.xml ```

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>br.com.abim</groupId>
	<artifactId>primo</artifactId>
	<version>0.1.0-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>primo</name>
	<url>http://maven.apache.org</url>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
	</properties>
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-shade-plugin</artifactId>
				<version>2.1</version>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>shade</goal>
						</goals>
						<configuration>
							<transformers>
								<transformer
									implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
									<mainClass>br.com.abim.primo.main.HelloWorld</mainClass>
								</transformer>
							</transformers>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>

	
</project>


```
#### Construa código Java

O Maven está  pronto para construir o projeto! Você pode executar vários `'goals'` do ciclo de vida de construção do Maven.  Esses `goals` incluem:  compilar o código do projeto, criar um pacote JAR ou instalar o pacote no repositório de dependência local do Maven (arquivo .m2).

Para experimentar a compilação, digite o seguinte na linha de comando:

`mvn compile`

Esse comando irá executar o Maven, dizendo para executar o `goal` de compilação. Quando terminar, você deverá encontrar os arquivos .class compilados no diretório `target/classes`.

Como é improvável que você queira distribuir ou trabalhar com arquivos `.class` diretamente, provavelmente você desejará executar o `goal` que gera o `jar`:

`mvn package`

O `goal package`  compilará seu código Java, executará quaisquer testes e terminará empacotando o código em um arquivo JAR dentro do diretório de destino. O nome do arquivo JAR será baseado no <artifactId> e <version> do projeto. Por exemplo, considerando o arquivo pom.xml mínimo criado anteriormente, o arquivo JAR será denominado `primo-0.0.1-SNAPSHOT.jar` .
	
	
#### Declare as Dependencias

O exemplo simples do `HelloWorld.java` é completamente autônomo e não depende de nenhuma biblioteca adicional. A maioria dos aplicativos, no entanto, depende de bibliotecas externas para lidar com funcionalidades comuns e complexas.

Por exemplo, suponha que, além de dizer "Hello World!", Você queira que o aplicativo imprima a data e a hora atuais. Embora você possa usar os recursos de data e hora nas bibliotecas Java nativas, é possível tornar as coisas mais interessantes usando as bibliotecas do Joda Time.

Primeiro, mude o `HelloWorld.java` para ficar assim:

```Java
package br.com.abim.primo.main;

import br.com.abim.primo.domain.Greeter;

public class HelloWorld {

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());
		System.out.println(greeter.showLocalTime());		
	}	
}
```
Em seguida, altere a classe `Greeter.java` para ficar assim:

```Java
package br.com.abim.primo.domain;

import org.joda.time.LocalTime;

public class Greeter {
	public String sayHello() {
		return "Hello world! How are you?";
	}

	public String showLocalTime() {
		LocalTime currentTime = new LocalTime();
		return "The current local time is: " + currentTime;
	}
}

```
Aqui, a classe `HelloWorld.java` usa a classe `LocalTime` da biblioteca `org.joda.time` para obter e imprimir a hora atual.

Se você fosse executar o `mvn compile` para criar o projeto agora, a compilação *falharia* porque você não declarou o Joda Time como uma dependência de compilação no `pom.xml`. Você pode corrigir isso adicionando as seguintes linhas ao `pom.xml` (dentro do elemento <project>):

```xml
	<dependencies>
		<dependency>
			<groupId>joda-time</groupId>
			<artifactId>joda-time</artifactId>
			<version>2.9.2</version>
		</dependency>
	</dependencies>
```
Agora, se você executar o pacote `mvn compile`  ou `mvn package`, o Maven deve resolver a dependência do Joda Time do repositório do Maven Central e a compilação será bem-sucedida.


#### Escrevendo um teste unirário

Primeiro adicione o JUnit como uma dependência ao seu `pom.xml`, com escopo do teste. Agora as dependências ficarão assim:
```XML
	<dependencies>
		<dependency>
			<groupId>joda-time</groupId>
			<artifactId>joda-time</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
```
Em seguida, crie um caso de teste como este:

`src/test/br/com/abim/primojava/HelloWorldTest.java`

```
package br.com.abim.primo;

import br.com.abim.primo.domain.Greeter;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import org.junit.Test;

public class HelloWorldTest {

	private Greeter greeter = new Greeter();

	@Test
	public void greeterSaysHello() {
		assertThat(greeter.sayHello(), containsString("Hello"));
	}

}
```

O Maven usa um plugin chamado "surefire" para executar testes de unidade. A configuração padrão deste plugin compila e executa todas as classes em `src/test/java`  com um nome correspondente a `*Test` (que termina com a palavra Test). Você pode executar os testes na linha de comando assim:

 ```mvn test```

ou apenas usando `mvn package` como já mostramos acima (existe uma definição de ciclo de vida em que "test" é incluído como um estágio em "package").

#### Desafio 

```

Crie um segundo teste unitário para o método showLocalTime()


```
