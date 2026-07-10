# Study Launcher — Android 16

This app schedules your lessons and tries to open the matching YouTube video at each scheduled time. It opens the **YouTube app first**, then uses the default browser if YouTube is not installed.

## Build an APK from your phone with GitHub

1. Create a new GitHub repository called `study-launcher`.
2. Upload every file from this project, keeping the folders exactly as they are. In GitHub, use **Add file → Upload files** and upload the extracted project contents.
3. Open the repository’s **Actions** tab.
4. Open **Build Android APK**. If GitHub asks, enable workflows.
5. Tap **Run workflow → Run workflow**.
6. Wait for the workflow to show a green check mark (usually a few minutes).
7. Open that completed workflow and download **Study-Launcher-APK** from **Artifacts**.
8. Extract the download and install `app-debug.apk` on your Android phone. Allow installs from your browser or Files app when Android asks.

## First launch

1. Open **Study Launcher**.
2. Tap **Enable automatic schedule**.
3. In the Android settings page, allow **Alarms & reminders**.
4. Keep the YouTube app installed for direct YouTube launches.

> Android 16 may block any app from bringing another app to the foreground in protected situations, such as while the phone is locked. The app will attempt the launch at every scheduled time when Android permits it.
