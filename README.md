# Notespace data science journal - simple demo
[Notespace](https://github.com/scicloj/notespace) creates a data science journal (literate programming) from a Clojure namespace.

[practicalli/scicloj-notespace-simple-demo](https://github.com/practicalli/scicloj-notespace-simple-demo) launches an empty notespace webpage and the Portal data navigation tool, each in their own browser windows on REPL startup.


## Developing the project
Start a REPL for the project with Leiningen or Clojure CLI tools (version 1.10.1.697 or greater and aliases from [practicalli/clojure-deps-edn](https://github.com/practicalli/clojure-deps-edn))

```
lein repl

clojure -M:env/dev:inspect/portal-clj
```

Wait a few seconds for the Portal and Notespace pages to load into your browser.

Evaluate the `(notespace/listen)` expression and the current namespace is loaded into the Notespace page.  If the Notespace page stops updating, evaluate this expression again.

Wrap values and function calls with the `tap>` function to see the values in the Portal window.


## Emacs support
A `.dir-locals.el` file is included for Clojure CLI tools, to use the `:env/dev` and `:inspect/portal-cli` aliases from [practicalli/clojure-deps-edn](https://github.com/practicalli/clojure-deps-edn) user level configuration.

When using `cider-jack-in` the aliases will be automatically added to jack-in startup command.

This is not required for Leinigen, which uses a `:dev` profile in the `project.clj` file to provide the necessary configuration.

`cider-connect` can also be used with Clojure CLI tools by running a REPL in a terminal using the command

```
cider -M:env/dev:inspect/portal:middleware/cider-clj
```



## Testing
Run the project tests (when they are added)
```
lein test

clojure -M:test/runner
```

## License
Copyright © 2020 Practicalli
Distributed under the [Creative Commons Attribution Share-Alike 4.0 International](https://creativecommons.org/)
