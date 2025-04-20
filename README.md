# Compose AI-Assisted Android App Template

This project is a template for native Android applications built using Jetpack Compose, leveraging AI code assistance -- Gemini and Claude Code CLI. It provides a foundation for developing modern, declarative UIs for native Android apps with Compose while incorporating best practices for theming and resource management.

## Key Features

*   **Jetpack Compose:** This project is built entirely with Jetpack Compose, Android's modern toolkit for building native UIs. It embraces a declarative approach, making UI development more intuitive and efficient.
*   **AI-Powered Development:** The template is designed to be easily extended and modified with the help of AI code assistants, such as Gemini and Claude Code CLI. These tools can accelerate development by generating code snippets, suggesting improvements, and assisting with debugging.
*   **Compose Theming Best Practices:**
    *   **Object-Based Style and Theme Resources:** The project demonstrates how to organize your app's styling and theming using object-based components in Kotlin. This approach promotes code clarity, reusability, and maintainability compared to traditional XML-based styles.
    *   **Centralized Color Management:** The project establishes a `Colors.kt` file as the single source of truth for all color definitions. This file uses Compose's `Color` class to define your app's color palette in a type-safe and organized manner.
    *   **Automatic `colors.xml` Generation:** A Gradle task is included that automatically generates the traditional `colors.xml` file (used for View-based UI elements or system resources) from the `Colors.kt` file. This ensures consistency between your Compose theme and any legacy or system-level UI components while avoiding manual color value duplication.

## Getting Started

1.  **Prerequisites:**
    *   Android Studio with the latest updates.
    *   Basic knowledge of Kotlin and Android development.
    *   Familiarity with Jetpack Compose concepts is helpful but not mandatory.

2.  **Clone the Repository:**

3.  **Open in Android Studio:** Open the cloned project in Android Studio.

4.  **Explore and Build:**
    *   Examine the `ui.theme` package to understand how theming is set up using object-based components and the `Typography` system.
    *   Check `Colors.kt` to see how the app's color palette is defined.
    *   Run the `generateColorsXml` Gradle task (e.g., from the Gradle tool window or by running `./gradlew generateColorsXml` in the terminal) to generate the `colors.xml` file from `Colors.kt`.
    *   Build and run the app on an emulator or a physical device.

5.  **Start Developing:**
    *   Modify the existing composables or create new ones to build your app's UI.
    *   Use Gemini or Claude Code CLI to assist with code generation, UI design, and problem-solving.
    *   Customize the theme, colors, and typography to match your app's branding and design requirements.

## AI Tools Integration (Examples)

Here are some examples of how you can use AI tools to enhance your development with this template:

*   **Generating a New Composable:** Ask Gemini or Claude to "generate a Jetpack Compose composable for a user profile screen with an avatar, name, and bio."
*   **Creating a Layout:** Request assistance in creating a specific layout, such as "create a Compose layout with a top app bar, a content area with scrolling, and a bottom navigation bar."
*   **Applying Styling:** Ask the AI to "apply the `titleLarge` style from the app's theme to this text composable."
*   **Modifying Colors:** Instruct the AI to "change the primary color in `Colors.kt` to #FF4081."
*   **Implementing Logic:** Seek help with implementing specific app logic, such as "how to handle user input in this form and save it to a database."

Remember to provide clear and specific prompts to get the best results from AI code assistants.

## License

Apache 2.0