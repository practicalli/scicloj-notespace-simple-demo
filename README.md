# Example Notespace journal project with Portal Inspector
[Notespace](https://github.com/scicloj/notespace) creates a data science journal in your browser from a specific Clojure namespace.

[Portal](https://github.com/djblue/portal) is a browser based data inspector to help you navigate and explore data structures.

[practicalli/scicloj-notespace-simple-demo](https://github.com/practicalli/scicloj-notespace-simple-demo) launches an empty notespace webpage and the Portal data navigation tool, each in their own browser windows on REPL startup.

## Requirements
It is recommended that Clojure CLI tools version 1.10.1.697 or greater is used, although there is also a Leiningen project configurationthat works for notespace but not for portal.

* [Java 11](https://adoptopenjdk.net/)
* [Clojure CLI tools](https://clojure.org/guides/getting_started) version 1.10.1.697 or greater or [Leinigen](https://leiningen.org/) version 2.9.x
* [practicalli/clojure-deps-edn](https://practicalli.github.io/clojure/clojure-tools/install/community-tools.html) user configuration for Clojure CLI tools  (not required if using Leinigen)
* A [Clojure aware editor](https://practicalli.github.io/clojure/clojure-editors/) such as [VS Code with Calva](https://practicalli.github.io/clojure/clojure-editors/editor-install-guides/vscode-calva.html#debian)


## Starting the REPL
Start a REPL for the project with Clojure CLI tools and aliases from [practicalli/clojure-deps-edn](https://practicalli.github.io/clojure/clojure-tools/install/community-tools.html)

```
clojure -M:env/dev:inspect/portal-clj:repl/rebel-nrepl
```

The command will start the repl using rebel readline to provide a rich terminal repl experience.

After a few moments a browser window will open automatically for notespace and another window for the portal data inspector.

> If using Leiningen, open a file from the project in a Clojure aware editor and start the REPL from the editor (e.g. jack-in).
> Evaluate `(notespace/init-with-browser)` to manually start notespace once the REPL has started.

## Using notespace
Once the notespace browser is running, cvaluate the `(notespace/listen)` expression to render the current namespace in the notespace browser.  This will display all the current top level forms (unless they are marked with `^kind/hidden`).

`listen` will automatically update the browser when the namespace file is saved.

`(notespace/init)` will clean the notespace and update the browser window if running.  This is a useful way to start again.  Evaluate `(notespace/listen)` to render the notespace.

## Using Portal to inspect data (Clojure CLI only)
Wrap values and function calls with the `tap>` function to see the values in the Portal window.

`tap>` can be used around a top level form or any expression where a returning true value will not interfere with the code execution.

```
(tap>
    (zipmap [:monday :tuesday :wednesday :thursday :friday :saturday :sunday]
            (range 10 20)))
```

> This project is not configured to run Portal from Leiningen (as I dont know how to do that yet - Pull Requests appreciated).


## Emacs support
The recommended approach is to run the REPL on the command line and use `cider-connect` from Emacs.  If the terminal repl is not going to be used, run the build in terminal REPL with Cider support using this command

```
cider -M:env/dev:inspect/portal:middleware/cider-clj
```


If using `cider-jack-in` rather than `cider-connect`, a `.dir-locals.el` file is included for Clojure CLI tools. The `.dir-locals.el` adds the `:env/dev` and `:inspect/portal-cli` aliases from [practicalli/clojure-deps-edn](https://github.com/practicalli/clojure-deps-edn) to cider-jack-in command.

If using Leiningen, run the `cider-jack-in-clj` to start the REPL.  `cider-connect` will not work with Leiningen run on the command line as the nrepl server and cider dependencies are not included in the Leiningen project.clj.
Leinigen uses a `:dev` profile in the `project.clj` file to provide the necessary configuration for notespace and portal, although neither browser windows will start automatically.  Code examples in the rich comment blocks will manually start the browser windows for notespace and portal.


## VS Code & Calva support
It is recommended to use Calva jack-in to work with this project, as it will add the libraries to run clj-kondo static analysis tool.

Click on the **nREPL** icon in the VS Code status bar (bottom bar)

Select **Start a REPL server and connect (a.k.a jack-in)**

Select **Clojure CLI** and check the `:env/dev` and `:inspect/portal-clj` aliases to run with Clojure CLI tools (automatically launches notespace and portal browser windows)

Alternatively, select **Leiningen** and check the `:dev` alias (will not automatically launch notespace and portal is not supported)


## Testing
No tests are currently defined.  When they are added, tests can be run via Leiningen or Clojure CLI tools.

Running tests using Clojure CLI tools
```
clojure -M:test/runner
```

Running tests using Leiningen
```
lein test
```


## License
Copyright © 2021 Practicalli
Distributed under the [Creative Commons Attribution Share-Alike 4.0 International](https://creativecommons.org/)
