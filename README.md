# Quotes-app : Random Quote Generator App

A simple Android application that displays random quotes using the ZenQuotes.io API. This app is built with Kotlin and demonstrates the usage of Retrofit for API integration.

## Features

- Fetch and display random quotes
- Display quote author
- Next button to load new quotes
- Loading indicator while fetching quotes
- Error handling for failed API requests

## Technologies Used

- Kotlin
- Android Studio
- Retrofit for API calls
- ViewBinding for UI
- Coroutines for asynchronous operations
- ZenQuotes.io API

## Screenshots

[![Demo screenshot](https://github.com/user-attachments/assets/cfd7d7d8-cb6d-4c2d-88f8-89faa4ead50d)
]

## Setup

1. Clone this repository
2. Open the project in Android Studio
3. Build and run the application

## Dependencies

Add these dependencies in your app's build.gradle file:

```gradle
dependencies {
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
}
```

## API Reference

This app uses the [ZenQuotes.io](https://zenquotes.io/) API to fetch random quotes.

## Learning Resources

If you're new to Android development, here are some topics to explore:
- Kotlin fundamentals
- Android Activity lifecycle
- ViewBinding
- Retrofit and API integration
- Coroutines in Android
- Error handling in Android

## Contributing

Feel free to fork this project and submit pull requests. As a beginner project, this is open to improvements and suggestions.

## License

MIT License

Copyright (c) 2024 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## Acknowledgments

- Thanks to ZenQuotes.io for providing the quotes API
- Built as a learning project for Android development with Kotlin
