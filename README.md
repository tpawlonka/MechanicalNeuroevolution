# MechanicalNeuroevolution

This is a rewrite of my old thesis project into Java for the purpose of exercising my Java skills.\
Compared to the original, it is equipped with a libgdx and scene2d based GUI which allows choosing parameters for the experiment without
the need to use arguments during startup or launch the application in different modes.\
It is written with extensibility in mind and will feature things which I didn't have time to include in the original,
such as customizable terrain and simulation conditions, and visual browsing of population history.\
The visual output mode is also a lot more sane and performant compared to the original version.

Copyright (C) Tadeusz Pawlonka

All use must comply with the GPL v3 license as outlined in LICENSE.md

libGDX, Box2D and Scene2D are distributed under the Apache 2.0 license, which is compatible with GPL v3.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/lib`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
