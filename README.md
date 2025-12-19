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

> **Project Context**: Developed as part of a 2-day Android Developer assignment for **Orufy Technologies Pvt. Ltd.**, focusing on core Android concepts and best practices.

---

## 📸 Screenshots

<div align="center">

### 🏠 Home Screen
<img src="Search" width="250" alt="Home Screen"/>

*Beautiful carousel with URL input and quick access to history*

---

### 🌍 WebView in Action
<img src="Screenshot (526).png" width="250" alt="WebView Screen"/>

*Full-featured browser experience with live website rendering*

---

### 📚 History Management
<img src="history" width="250" alt="History Screen"/>

*Complete browsing history with timestamps and management options*

---

### 🎬 App Flow
<table>
  <tr>
    <td align="center">
      <img src="screenshots/home_screen.png" width="200"/><br>
      <b>1. Enter URL</b><br>
      <sub>Input validation & carousel</sub>
    </td>
    <td align="center">
      <img src="screenshots/webview_screen.png" width="200"/><br>
      <b>2. Browse Website</b><br>
      <sub>Full WebView integration</sub>
    </td>
    <td align="center">
      <img src="screenshots/history_screen.png" width="200"/><br>
      <b>3. View History</b><br>
      <sub>Local storage & export</sub>
    </td>
  </tr>
</table>

</div>

---

## ✨ Features

### 🏠 Home Screen
- ✅ **Interactive Carousel** - Beautiful image slider with dot indicators
- ✅ **Smart URL Input** - Real-time validation and auto-formatting
- ✅ **Quick History Access** - One-tap access from top menu
- ✅ **Material Design 3** - Modern, clean UI components
- ✅ **Auto HTTPS** - Automatically prepends `https://` to URLs

### 🌍 WebView Screen
- ✅ **Full Browser Experience** - JavaScript enabled with DOM storage
- ✅ **Progress Indicator** - Real-time loading feedback
- ✅ **Smart Navigation** - Back/Close buttons with different behaviors
- ✅ **Dynamic Title** - Auto-updates with page title
- ✅ **URL Display** - Shows current page URL in toolbar

### 📚 History Screen
- ✅ **Chronological List** - All visited URLs with timestamps
- ✅ **One-Tap Revisit** - Click any URL to reopen
- ✅ **Bulk Management** - Clear all history at once
- ✅ **API Integration** - Export history to Beeceptor endpoint
- ✅ **Empty State** - Elegant placeholder when no history exists

---

## 🎯 Assignment Requirements ✓

<table>
<tr>
<td width="50%">

### ✅ Implemented Features

- [x] Three native screens (Home, WebView, History)
- [x] Top App Bar with History button
- [x] URL input with validation
- [x] Image carousel with 3 slides
- [x] Dot indicators
- [x] WebView integration
- [x] Local storage (Room DB)
- [x] Timestamp tracking
- [x] Back/Close navigation
- [x] History list with RecyclerView
- [x] Clear history functionality
- [x] Upload to API (Beeceptor)

</td>
<td width="50%">

### 🛡️ Edge Cases Handled

- [x] Empty input validation
- [x] Invalid URL format detection
- [x] Leading/trailing spaces trimmed
- [x] Auto HTTPS prepending
- [x] Empty history state
- [x] Network error handling
- [x] WebView back navigation
- [x] Retained URL on back press
- [x] Cleared URL on close press
- [x] Database transaction safety

</td>
</tr>
</table>

---

## 🛠 Tech Stack

### Core Technologies
```kotlin
Language: Kotlin
Min SDK: API 24 (Android 7.0)
Target SDK: API 34 (Android 14)
Build System: Gradle 8.0+
```

### Android Components
- **Architecture**: MVVM Pattern with Repository
- **Database**: Room (SQLite wrapper)
- **UI Framework**: XML with Material Design 3
- **View Binding**: Enabled for type-safe access
- **Coroutines**: Asynchronous operations
- **LiveData**: Reactive data observation

### Key Libraries
```gradle
// UI & Material Design
implementation 'com.google.android.material:material:1.11.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
implementation 'androidx.viewpager2:viewpager2:1.0.0'

// Room Database
implementation 'androidx.room:room-runtime:2.6.1'
implementation 'androidx.room:room-ktx:2.6.1'
kapt 'androidx.room:room-compiler:2.6.1'

// Lifecycle Components
implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.7.0'
implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.7.0'

// Kotlin Coroutines
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3'
```

---

## 📂 Project Structure

```
com.example.quickwebview/
│
├── 📱 Activities
│   ├── MainActivity.kt              # Home screen with URL input & carousel
│   ├── WebViewActivity.kt           # Browser screen with navigation
│   └── HistoryActivity.kt           # History management screen
│
├── 🎨 Adapters
│   ├── CarouselAdapter.kt           # ViewPager2 for image carousel
│   └── HistoryAdapter.kt            # RecyclerView with DiffUtil
│
├── 💾 Data Layer
│   ├── AppDatabase.kt               # Room database singleton
│   ├── UrlHistoryDao.kt             # Database operations (CRUD)
│   └── UrlHistoryEntity.kt          # Data model with annotations
│
├── 🔄 Repository
│   └── UrlRepository.kt             # Data source abstraction layer
│
├── 🛠 Utils
│   └── UrlValidator.kt              # URL validation & formatting
│
└── 📐 Resources
    ├── layout/
    │   ├── activity_main.xml
    │   ├── activity_webview.xml
    │   ├── activity_history.xml
    │   └── item_history.xml
    ├── menu/
    │   └── menu_home.xml
    └── drawable/
        ├── banner_1.png
        ├── banner_2.png
        └── banner_3.png
```

---

## 🏗 Architecture

```
┌─────────────────────────────────────────────────────┐
│                  UI Layer (Activities)              │
│   MainActivity | WebViewActivity | HistoryActivity  │
│              ↓ View Binding ↓                       │
└──────────────────┬──────────────────────────────────┘
                   │
                   │ LiveData Observations
                   ↓
┌──────────────────────────────────────────────────────┐
│              Repository Layer                        │
│           (UrlRepository.kt)                         │
│    • Data source abstraction                         │
│    • Business logic                                  │
│    • API calls & DB operations                       │
└──────────────────┬──────────────────────────────────┘
                   │
                   │ Coroutines
                   ↓
┌──────────────────────────────────────────────────────┐
│           Data Layer (Room Database)                 │
│   UrlHistoryDao | UrlHistoryEntity | AppDatabase    │
│    • Local data persistence                          │
│    • Query operations                                │
└──────────────────────────────────────────────────────┘
```

**Architecture Principles:**
- ✅ Single Responsibility Principle
- ✅ Separation of Concerns
- ✅ Repository Pattern
- ✅ Observer Pattern (LiveData)
- ✅ Dependency Injection (manual)

---

## 🚀 Installation & Setup

### Prerequisites
- **Android Studio**: Hedgehog (2023.1.1) or later
- **JDK**: Version 17
- **Android SDK**: API 24 - API 34
- **Kotlin**: Version 1.9.0+
- **Gradle**: Version 8.0+

### Quick Start

1️⃣ **Clone the repository**
```bash
git clone https://github.com/vishalsuryavanshi/quickwebview.git
cd quickwebview
```

2️⃣ **Open in Android Studio**
- Launch Android Studio
- Select `File` → `Open`
- Navigate to the cloned directory
- Wait for Gradle sync to complete

3️⃣ **Build the project**
```bash
./gradlew clean build
```

4️⃣ **Run the app**
- Connect an Android device (API 24+) or start an emulator
- Click the **Run** button (▶️) in Android Studio
- Or use command: `./gradlew installDebug`

---

## 💡 Key Implementation Highlights

### 🔐 URL Validation Logic
```kotlin
private fun validateUrl(input: String): String? {
    var url = input.trim()
    
    // Handle empty input
    if (url.isEmpty()) {
        binding.tilUrl.error = "Please enter a URL"
        return null
    }
    
    // Auto-prepend HTTPS
    if (!url.startsWith("http://") && !url.startsWith("https://")) {
        url = "https://$url"
    }
    
    // Validate URL pattern
    return if (Patterns.WEB_URL.matcher(url).matches()) {
        binding.tilUrl.error = null
        url
    } else {
        binding.tilUrl.error = "Please enter a valid URL"
        null
    }
}
```

### 💾 Room Database Setup
```kotlin
@Database(entities = [UrlHistoryEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun urlHistoryDao(): UrlHistoryDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "quickwebview_database"
                ).fallbackToDestructiveMigration()
                 .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
```

### 🌐 WebView Configuration
```kotlin
private fun setupWebView() {
    binding.webView.settings.apply {
        javaScriptEnabled = true
        domStorageEnabled = true
        loadWithOverviewMode = true
        useWideViewPort = true
        builtInZoomControls = true
        displayZoomControls = false
        setSupportZoom(true)
    }
    
    binding.webView.webViewClient = object : WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            binding.progressBar.visibility = View.GONE
            binding.topAppBar.title = view?.title ?: url
        }
    }
}
```

### 📤 API Integration (Beeceptor)
```kotlin
private fun uploadHistory() {
    lifecycleScope.launch {
        try {
            val historyList = repository.getAllHistorySync()
            val response = repository.uploadToApi(historyList)
            
            Toast.makeText(
                this@HistoryActivity,
                "History uploaded successfully!",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: Exception) {
            Toast.makeText(
                this@HistoryActivity,
                "Upload failed: ${e.message}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
```

---

## 🎯 Assignment Completion Report

<table>
<tr>
<td>

### ⏱️ Timeline
- **Duration**: 2 Days
- **Started**: December 18, 2025
- **Completed**: December 19, 2025
- **Status**: ✅ Submitted

</td>
<td>

### 📊 Statistics
- **Total Screens**: 3
- **Lines of Code**: ~800
- **Activities**: 3
- **Adapters**: 2
- **Database Entities**: 1

</td>
</tr>
</table>

### ✅ All Requirements Met

| Requirement | Status | Implementation |
|------------|--------|----------------|
| Home Screen with Input | ✅ | Material TextInputLayout with validation |
| Image Carousel | ✅ | ViewPager2 with 3 slides + dot indicators |
| History Button in App Bar | ✅ | MaterialToolbar with overflow menu |
| WebView Integration | ✅ | Full-featured with progress & navigation |
| Local Storage | ✅ | Room database with timestamps |
| History List | ✅ | RecyclerView with DiffUtil |
| Clear History | ✅ | With confirmation dialog |
| Upload to API | ✅ | Beeceptor endpoint integration |
| Empty Input Handling | ✅ | Inline error + Toast message |
| Invalid URL Detection | ✅ | Regex validation with feedback |
| Back/Close Navigation | ✅ | Different behaviors implemented |
| URL Display Update | ✅ | Dynamic toolbar title updates |

---

## 🔮 Future Enhancements

- [ ] 🔖 **Bookmark Management** - Save favorite sites
- [ ] 🔍 **Search in History** - Filter by URL or date
- [ ] 📥 **Download Manager** - Handle file downloads
- [ ] 🕶️ **Incognito Mode** - Private browsing
- [ ] 📑 **Multiple Tabs** - Tab management system
- [ ] 🌙 **Dark Mode** - Theme switching
- [ ] 📊 **Export History** - CSV/PDF export
- [ ] 🛡️ **Ad Blocker** - Block ads and trackers
- [ ] 🔐 **Password Manager** - Autofill integration
- [ ] 📱 **Desktop Mode** - User agent switching

---

## 🤝 Contributing

While this is an assignment project, suggestions and improvements are welcome!

```bash
# Fork the repo
git clone https://github.com/yourusername/quickwebview.git

# Create feature branch
git checkout -b feature/amazing-feature

# Commit changes
git commit -m "Add amazing feature"

# Push to branch
git push origin feature/amazing-feature

# Open Pull Request
```

---

## 📄 License

This project is created for educational and assignment evaluation purposes.

```
Copyright (c) 2025 Vishal Suryavanshi
Educational Project - Orufy Technologies Assignment
```

---

## 👨‍💻 Author

<div align="center">

### **Vishal Suryavanshi**
*Android Developer Intern*

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/vishalsuryavanshi)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/vishal-suryavanshi)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:your.email@example.com)

</div>

---

## 🙏 Acknowledgments

- **Orufy Technologies Pvt. Ltd.** - Assignment opportunity
- **Material Design** - UI/UX guidelines
- **Android Developers** - Comprehensive documentation
- **Stack Overflow** - Community support
- **Kotlin Community** - Best practices

---

## 📞 Contact & Support

**For Assignment Evaluation:**
- 📧 Email: your.email@example.com
- 💼 Portfolio: [Your Portfolio Link]
- 📱 Phone: +91-XXXXXXXXXX

**Assignment Submission:**
- ✅ GitHub Repository: [This Repository]
- ✅ Drive Link: [CV + Portfolio]
- ✅ Demo Video: [Drive Link]
- ✅ APK File: [Download Link]

---

<div align="center">

### 🎯 **Assignment Submitted Successfully** ✅

**Built with ❤️ for Android Development**

⭐ **Star this repo if you found it helpful!** ⭐

---

*Developed as part of Android Developer Assignment*  
*Orufy Technologies Pvt. Ltd. • December 2025*

</div>
