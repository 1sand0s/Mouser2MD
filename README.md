# Mouser2MD
![Travis (.com)](https://img.shields.io/travis/com/1sand0s/Mouser2MD)
![GitHub](https://img.shields.io/github/license/1sand0s/Mouser2MD)

JSoup based HTML parser for parsing orders from Mouser.com into BOM for use in Markdown

<h2>What is it?</h2>
I often order components from Mouser.com for my projects and I like to write about my projects in my blog. I needed a convenient way of parsing the orders into markdown
which I can easily copy paste into my blog supported by pelican (particularly for including BOMs). Since I couldn't find any existing way of doing it, I decided to build
my own. Simply follow the instructions below to build it, and then execute the jar with the URL to your Mouser.com order.

<h2>How to build</h2>


1. <h4>Install JDK:</h4>

    Download and install openJDK 17, and set the environment variable ***JAVA_HOME*** to point to the "bin" folder of your JDK installation.

2. <h4>Install Git:</h4>

    Download [Git](http://git-scm.com/downloads) and install it.

3. <h4>Install Maven:</h4>

    Download [Maven v3.8.4](https://maven.apache.org/download.cgi) and install it.

3. <h4>Clone the cyphssert repository:</h4>

    If you installed Git, execute the following command: `https://github.com/1sand0s/Mouser2MD.git`<br>
    Otherwise, download the repository as a [zip ball](https://github.com/1sand0s/Mouser2MD/archive/refs/heads/main.zip) and extract it.

6. <h4>Build:</h4>

    Open a command prompt/terminal, `cd` to the project root directory, and execute `mvn clean install package assembly:single`.

7. <h4>Running:</h4>

    To convert a Mouser.com order into BOM for markdown, `cd` to the `target` directory inside project root directory, and execute 'java -jar mouser2md-0.0.1-SNAPSHOT-jar-with-dependencies.jar <PASTE URL TO MOUSER.COM ORDER HERE>'.
