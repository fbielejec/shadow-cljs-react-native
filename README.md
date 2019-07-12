# [shadow-cljs-react-native](https://github.com/fbielejec/shadow-cljs-react-native)
 
Demo app showing how to use [shadow-cljs](https://github.com/shadow-cljs/) to target React Native.

## Development

```bash
# first run : install the dependencies
$ yarn deps

# start watcher
$ yarn app:watch

# wait for compilation to finish
$ yarn app:android
# or
$ yarn app:ios

# open the project in the simulator

```

## REPL

M-x cider-connect

```clojure
(shadow.cljs.devtools.api/nrepl-select :app)
```

## Simulator

### General

Disable _Live Reloading_ and _Hot Reloading_ in the simulator.
Shadow-cljs included it's own `{:dev/after-load true}` mechanism for live-reloading, which will preserve app state (for example if you are using [re-frame](https://github.com/Day8/re-frame)).

### Android

```bash
yarn app:android
```

### iOS on MacOS

Open XCode IOS simulator folowed by:

```bash
yarn app:ios
```

### iOS on Linux

Please read an accompanying blog post:
https://www.blog.nodrama.io/react-native-xcode-linux/
