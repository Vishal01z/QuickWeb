# 🌐 QuickWebView

<div align="center">

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)
![Material Design](https://img.shields.io/badge/Material%20Design-757575?style=for-the-badge&logo=material-design&logoColor=white)

**A lightweight in-app browser demonstrating modern Android development practices**

[Features](#-features) • [Screenshots](#-screenshots) • [Tech Stack](#-tech-stack) • [Installation](#-installation) • [Architecture](#-architecture)

</div>

---

## 📋 Overview

QuickWebView is a native Android application that serves as a lightweight in-app browser with history management. Built with Kotlin and modern Android libraries, it demonstrates clean architecture principles, local data persistence, and seamless WebView integration.

> **Project Context**: Developed as part of a 2-day Android Developer assignment, focusing on core Android concepts and best practices.

---

## ✨ Features

### 🏠 Home Screen
- ✅ URL input with real-time validation
- ✅ Automatic `https://` protocol handling
- ✅ Interactive image carousel with dot indicators
- ✅ Quick access to browsing history
- ✅ Material Design UI components

### 🌍 WebView Screen
- ✅ Full-featured web browser experience
- ✅ Page loading progress indicator
- ✅ Navigation controls (back/forward)
- ✅ Dynamic page title display
- ✅ JavaScript support enabled

### 📚 History Screen
- ✅ Chronological list of visited URLs
- ✅ Timestamp for each entry
- ✅ One-tap to revisit websites
- ✅ Clear all history option
- ✅ Export history to API (Beeceptor integration)
- ✅ Empty state handling

---

## 📸 Screenshots

<div align="center">

| Home Screen | WebView Screen | History Screen |
|------------|---------------|---------------|
| *URL input & carousel* | *Website rendering* | *Browsing history* |

</div>

> *Add your screenshots here*

---

## 🛠 Tech Stack

### Core Technologies
- **Language**: Kotlin
- **UI Framework**: XML Layouts
- **Design System**: Material Design 3

### Android Components
- **Architecture**: MVVM Pattern
- **Database**: Room (SQLite)
- **Navigation**: Activity-based
- **View Binding**: Enabled for type-safe view access
- **Coroutines**: For asynchronous operations

### Libraries
```gradle
// UI & Material Design
implementation 'com.google.android.material:material:1.11.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
implementation 'androidx.viewpager2:viewpager2:1.0.0'

// Room Database
implementation 'androidx.room:room-runtime:2.6.1'
implementation 'androidx.room:room-ktx:2.6.1'
kapt 'androidx.room:room-compiler:2.6.1'

// Lifecycle
implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.7.0'
```

---

## 📂 Project Structure

```
com.example.quickwebview/
│
├── 📱 Activities
│   ├── MainActivity.kt              # Home screen with URL input
│   ├── WebViewActivity.kt           # Browser screen
│   └── HistoryActivity.kt           # History management
│
├── 🎨 Adapters
│   ├── CarouselAdapter.kt           # ViewPager2 image carousel
│   └── HistoryAdapter.kt            # RecyclerView for history
│
├── 💾 Data Layer
│   ├── AppDatabase.kt               # Room database instance
│   ├── UrlHistoryDao.kt             # Database operations
│   └── UrlHistoryEntity.kt          # Data model
│
├── 🔄 Repository
│   └── UrlRepository.kt             # Data source abstraction
│
└── 🛠 Utils
    └── UrlValidator.kt              # URL validation logic
```

---

## 🏗 Architecture

```
┌─────────────────────────────────────────────┐
│              UI Layer (Activities)          │
│  MainActivity | WebViewActivity | History   │
└──────────────────┬──────────────────────────┘
                   │
┌──────────────────▼──────────────────────────┐
│           Repository Layer                  │
│         (UrlRepository)                     │
└──────────────────┬──────────────────────────┘
                   │
┌──────────────────▼──────────────────────────┐
│         Data Layer (Room DB)                │
│   UrlHistoryDao | UrlHistoryEntity          │
└─────────────────────────────────────────────┘
```

**Key Principles:**
- ✅ Separation of Concerns
- ✅ Single Responsibility
- ✅ Repository Pattern for data abstraction
- ✅ ViewBinding for type-safe view access

---

## 🚀 Installation

### Prerequisites
- Android Studio (Arctic Fox or later)
- JDK 17
- Android SDK (API 24+)
- Kotlin 1.9+

### Steps

1. **Clone the repository**
```bash
git clone https://github.com/yourusername/quickwebview.git
cd quickwebview
```

2. **Open in Android Studio**
- Launch Android Studio
- Select "Open an Existing Project"
- Navigate to the cloned directory

3. **Sync Gradle**
```bash
./gradlew build
```

4. **Run the app**
- Connect an Android device or start an emulator
- Click the "Run" button in Android Studio

---

## 🎯 Key Implementation Details

### URL Validation
```kotlin
private fun validateUrl(input: String): String? {
    var url = input.trim()
    
    if (url.isEmpty()) return null
    
    if (!url.startsWith("http://") && !url.startsWith("https://")) {
        url = "https://$url"
    }
    
    return if (Patterns.WEB_URL.matcher(url).matches()) url else null
}
```

### Room Database Setup
```kotlin
@Database(entities = [UrlHistoryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun urlHistoryDao(): UrlHistoryDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "quickwebview_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
```

### WebView Configuration
```kotlin
webView.settings.apply {
    javaScriptEnabled = true
    domStorageEnabled = true
    loadWithOverviewMode = true
    useWideViewPort = true
}
```

---

## 📊 Features Checklist

- [x] URL input validation
- [x] WebView integration
- [x] Room database persistence
- [x] History management
- [x] Image carousel
- [x] Material Design UI
- [x] Back navigation handling
- [x] Loading indicators
- [x] Empty state handling
- [x] API integration (Beeceptor)

---

## 🔮 Future Enhancements

- [ ] Bookmark functionality
- [ ] Search history feature
- [ ] Download manager
- [ ] Incognito mode
- [ ] Multiple tabs support
- [ ] Dark mode theme
- [ ] Export history as CSV/PDF
- [ ] Ad blocker integration

---

## 📝 Assignment Requirements

This project was completed as part of a **2-day Android Developer internship assignment** with the following objectives:

✅ **Core Requirements Met:**
- Native Android development using Kotlin
- Three functional screens
- WebView integration
- Local data persistence
- Clean UI/UX implementation
- No unnecessary third-party dependencies

✅ **Timeline:** Completed within 2 days
✅ **Code Quality:** Clean, documented, and maintainable

---

## 🤝 Contributing

While this is an assignment project, suggestions and feedback are welcome!

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is created for educational and assignment purposes.

---

## 👨‍💻 Author

**Vishal Suryavanshi**

- 💼 Android Developer Intern
- 📧 Email: your.email@example.com
- 💻 GitHub: [@yourusername](https://github.com/yourusername)
- 🔗 LinkedIn: [Your LinkedIn](https://linkedin.com/in/yourprofile)

---

## 🙏 Acknowledgments

- Material Design Guidelines
- Android Developer Documentation
- Stack Overflow Community
- Assignment Evaluators

---

<div align="center">

**⭐ If you found this project helpful, please consider giving it a star!**

Made with ❤️ for Android Development

</div>
