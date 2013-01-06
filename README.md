# GitHub -> Hatena::Graph

This command-line utility send data outputed by [GitHub Counter][github-counter] to [Hatena::Graph][hatena-graph].
It is dependent on [Hatena::Graph API for Clojure][hatena-graph-api-for-clojure].

[github-counter]: https://github.com/bouzuya/clj-github-counter
[hatena-graph]: http://graph.hatena.ne.jp/
[hatena-graph-api-for-clojure]: https://github.com/bouzuya/clj-hatena-graph

## Installation

    $ git clone git://github.com/bouzuya/clj-github-to-hatena-graph.git
    $ cd clj-github-to-hatena-graph
    $ cat <<EOT >resources/my.properties
    filename=/home/user/github-counter.txt
    graphnames="GitHub Followers","GitHub Following","GitHub Public Repos","GitHub Public Gists"
    username=hatena-username
    password=hatena-password
    EOT
    $ lein uberjar
    $ cp target/github-to-hatena-graph-0.1.0-standalone.jar [install-directory]

## Usage

    $ java -jar github-to-hatena-graph-0.1.0-standalone.jar

## License

Copyright © 2013 bouzuya

Distributed under the Eclipse Public License, the same as Clojure.

