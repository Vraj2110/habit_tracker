TaskSync
TaskSync is a modern Android task assignment and team collaboration app built with Kotlin and Jetpack Compose, using XML for the Android manifest and standard resource configurations. Designed with both Light and Dark themes, it helps individuals and groups create tasks, assign responsibilities, track progress, manage schedules, and stay on top of notifications.
✨ Features
 * Dashboard & Progress Overview: Track completion progress at a glance with visual progress indicators and upcoming task summaries.
 * Task Creation & Assignment: Create tasks with details, deadlines, and group/member assignments.
 * Tasks Management: Browse, filter, and manage active and assigned tasks with quick-add actions.
 * Calendar View: View scheduled tasks across a monthly calendar and plan upcoming deadlines.
 * Group & Member Collaboration: Create and edit groups, manage group members, configure group settings, and view group/task details.
 * Notifications: Stay updated on task assignments, updates, and reminders.
 * Authentication & Profile Settings: Sign in or register an account, customize app preferences, and switch between Light and Dark themes.
🛠️ Tech Stack
 * Language: Kotlin
 * UI Toolkit: Jetpack Compose (Material 3, Light & Dark Mode support)
 * Manifest & Resources: XML (AndroidManifest.xml, res/values, res/xml, drawables/icons)
 * Platform: Android
📁 Project Structure
TaskSync/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/tasksync/
│   │   │   │   ├── ui/
│   │   │   │   │   ├── theme/          # Light & Dark color schemes, typography, shapes
│   │   │   │   │   ├── screens/        # Dashboard, Tasks, Create Task, Calendar, Groups, Profile, Auth, Notifications
│   │   │   │   │   └── components/     # Reusable Compose UI components
│   │   │   │   └── MainActivity.kt     # App entry point & Compose root
│   │   │   ├── res/
│   │   │   │   ├── values/           # strings.xml, themes.xml, colors.xml
│   │   │   │   ├── drawable/         # Vector drawables & icons
│   │   │   │   └── xml/              # Backup & network/resource XML configs
│   │   │   └── AndroidManifest.xml   # App permissions, activities & theme declaration
│   │   └── test/                     # Unit tests
│   └── build.gradle.kts              # App-level Gradle & Compose dependencies
└── build.gradle.kts                  # Project-level Gradle configuration

🚀 Getting Started
Prerequisites
 * Android Studio (latest stable release with Kotlin & Jetpack Compose support)
 * JDK 17+
 * Android SDK with modern compileSdk and minSdk configured in app/build.gradle.kts
Setup & Run
 * Clone the repository:
   git clone https://github.com/your-username/tasksync.git

 * Open the project in Android Studio.
 * Allow Gradle to sync dependencies and index resources.
 * Select an Android emulator or connected physical device and click Run (Shift + F10 / Ctrl + R).
📄 License
This project is licensed under the MIT License. See the LICENSE file for more details.
