<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/NeoTamia/kotlin-template">
    <img src="https://avatars.githubusercontent.com/u/210235009?s=200&v=4" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">kotlin-template</h3>

  <p align="center">
    A template for Kotlin projects. <br />
    <br />
    <a href="https://github.com/NeoTamia/kotlin-template/issues">Report Bug</a>
    ·
    <a href="https://github.com/NeoTamia/kotlin-template/issues">Request Feature</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#uses">Uses</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li>
        <a href="#usage">Usage</a>
        <ul>
            <li><a href="#running">Running</a></li>
        </ul>
    </li>
    <li>
        <a href="#build">Build</a>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#authors">Authors</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

This project is a template for Kotlin projects, pre-configured with common tools and best practices.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Uses

* [![kotlin][kotlin]][kotlin-url]
* [![gradle][gradle]][gradle-url]
* [![ktlint][ktlint]][ktlint-url]
* [![shadow][shadow]][shadow-url]
* [![git][git]][git-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

You will need to install some tools to run the project.

- You need [JDK 21](https://adoptium.net/temurin/releases/?version=21) or higher.
- You will need to install [Git][git-url] to clone the project.

### Installation

Clone the project and build it.

#### Clone & build

```sh
git clone git@github.com:NeoTamia/kotlin-template.git
cd kotlin-template
./gradlew build
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE -->
## Usage

### Running

You can run the project with the following command:

```sh
./gradlew :modules:core:run
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- Build -->
## Build

If you need to build the project, run:

```bash
./gradlew build
```

The artifacts will be available in the `build/libs` and `modules/*/build/libs` directories.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

Read the [contributing guide][contributing-url] to learn how to contribute to the project.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- LICENSE -->
## License

Distributed under the MIT License. See [LICENSE][license-url] for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Authors

<table>
    <tbody>
        <tr>
            <td align="center"><a href="https://github.com/alwyn974/"><img src="https://avatars.githubusercontent.com/u/47529956?v=4?s=100" width="100px;" alt="Alwyn974"/><br /><sub><b>Alwyn974</b></sub></a><br /></td>
        </tr>
    </tbody>
</table>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/NeoTamia/kotlin-template.svg?style=for-the-badge
[contributors-url]: https://github.com/NeoTamia/kotlin-template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/NeoTamia/kotlin-template.svg?style=for-the-badge
[forks-url]: https://github.com/NeoTamia/kotlin-template/network/members
[stars-shield]: https://img.shields.io/github/stars/NeoTamia/kotlin-template.svg?style=for-the-badge
[stars-url]: https://github.com/NeoTamia/kotlin-template/stargazers
[issues-shield]: https://img.shields.io/github/issues/NeoTamia/kotlin-template.svg?style=for-the-badge
[issues-url]: https://github.com/NeoTamia/kotlin-template/issues
[license-shield]: https://img.shields.io/github/license/NeoTamia/kotlin-template.svg?style=for-the-badge
[license-url]: https://github.com/NeoTamia/kotlin-template/blob/master/LICENSE
[product-screenshot]: https://avatars.githubusercontent.com/u/116024069?s=200&v=4
[contributing-url]: CONTRIBUTING.md

[kotlin]: https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white
[kotlin-url]: https://kotlinlang.org/
[gradle]: https://img.shields.io/badge/gradle-%2302303A.svg?style=for-the-badge&logo=gradle&logoColor=white
[gradle-url]: https://gradle.org/
[ktlint]: https://img.shields.io/badge/ktlint-%23FF4081.svg?style=for-the-badge&logo=kotlin&logoColor=white
[ktlint-url]: https://pinterest.github.io/ktlint/
[shadow]: https://img.shields.io/badge/shadow-%23000000.svg?style=for-the-badge&logo=gradle&logoColor=white
[shadow-url]: https://github.com/GradleUp/shadow-gradle-plugin
[git]: https://img.shields.io/badge/git-%23F05032.svg?style=for-the-badge&logo=git&logoColor=white
[git-url]: https://git-scm.com/
