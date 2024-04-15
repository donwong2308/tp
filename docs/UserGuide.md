---
layout: default.md
title: "User Guide"
pageNav: 3
---

# Dormie User Guide

## Introduction

### Welcome Note
Welcome to the user guide for Dormie, your ultimate companion for dormitory living! 
Making new friends in the dorm can be both exciting and challenging, but with Dormie, we aim to make your experience as smooth and enjoyable as possible.

### Dormie Overview
Dormie is an application developed for college students living in dorms. 
It helps them connect with their dorm mates in a simple way. With Dormie, they can easily see when their friends are free, and keep track of their important dates and contact details. 
It makes organising social events less stressful and helps students stay connected with each other.

### Purpose of this User Guide
In this user guide, we will walk you through the installation, features and functionalities of Dormie, providing step-by-step instructions and helpful tips along the way. 
If you don't understand why your command went wrong, this guide will be your best toolbox to troubleshoot!

### Who this User Guide is for
This user guide is created to mainly serve users who are new to using Dormie and may not be well-versed in using Command-Line Interface (CLI) Desktop applications.
It can also help regular users refresh their memory if they forget any of the commands.

---

## Using This User Guide

### Searching for Keywords
1. Press the Ctrl + F keys on your keyboard. For MacOS users, it will be Command + F.
2. A search bar or dialog box should appear on your screen. A screenshot is shown below.
   ![Screenshot of search bar](images/ctrl-F.png)
3. Type the keyword or phrase you want to search for in the search bar and press enter.

### Additional Note
- **Copying and Pasting from this User Guide** <br> If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.

---

<div style="page-break-after: always;"></div>

<!-- * Table of Contents -->
<page-nav-print>Table of Contents</page-nav-print>

<div style="page-break-after: always;"></div>

## Quick start

1. Ensure you have Java `11` installed in your Computer.
    - MacOS: [Java 11](https://www.azul.com/downloads/?version=java-11-lts&os=macos&architecture=arm-64-bit&package=jdk-fx#zulu)
    - Windows: [Java 11](https://www.oracle.com/java/technologies/downloads/#java11-windows)

1. Download the latest `dormie.jar` from [here](https://github.com/AY2324S2-CS2103T-F11-4/tp/releases).

1. Create a new _Home Folder_ you want Dormie to permanently reside in.
    - Move Dormie into the _Home Folder_.
    - This is where Dormie and all it's supporting data will be stored.

1. Open a command terminal (`Terminal` for MacOS, or `Windows Terminal` for Windows).
    - MacOS:
        1. Right click the _Home Folder_.
        2. Then, click `New Terminal at Folder`. If not found, try to left click `Services` to show (depends on MacOS version).
    - Windows:
        1. Navigate into the _Home Folder_.
        2. Right click anywhere inside the _Home Folder_.
        3. Left click `Open in Windows Terminal`.

1. Paste this Command into the new terminal window `java -jar dormie.jar` and press enter.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it.<br>
   Quick Tutorial:
    - `add n/John Doe p/98765432 ` : Adds a contact named `John Doe` to Dormie with the specified phone number.
    - `find John` : Finds a contact with `John` in his name.
    - `delete 1` : Deletes the first contact shown in the current list.
    - `list` : Lists all contacts again.

1. Refer to [Features](#features) below for details of each command
   or to [Command Summary](#command-summary) for a summary of the commands.

---

<div style="page-break-after: always;"></div>

## Navigating the User Interface

![UiLabeled](images/UiLabeled.jpeg)

1. **Taskbar:** Where the `File` and `Help` buttons reside.

1. **Command Box:** Where commands to manipulate the address book are entered.

1. **Status Message Box:** Where Status Messages from executing commands are shown.

1. **Person Card:** Where details of a person are displayed.

1. **Person List:** Where a collection person cards are displayed.

---

<div style="page-break-after: always;"></div>

## Command summary

| Action                | Format, Examples                                                                                                                                                        |
|-----------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**               | `add n/NAME p/PHONE_NUMBER [e/EMAIL] [r/ROOM_NUMBER] [t/TELEGRAM_HANDLE] [b/BIRTHDAY] [d/DORM_TAG] [ft/FREE_TIME_TAG]...` <br> e.g. `add n/Alice Lim p/91234567`        |
| **Add Free Time**     | `addTime INDEX ft/FREE_TIME_TAG...`<br> e.g. `addTime 1 ft/Mon:0800-1200`                                                                                               |
| **Clear**             | `clear`                                                                                                                                                                 |
| **Delete**            | `delete INDEX`<br> e.g. `delete 3`                                                                                                                                      |
| **Delete Free Time**  | `deleteTime INDEX ft/FREE_TIME_TAG...`<br> e.g. `deleteTime 1 ft/Mon:0800-1200`                                                                                         |
| **Edit**              | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [r/ROOM_NUMBER] [t/TELEGRAM_HANDLE] [b/BIRTHDAY] [d/DORM_TAG] [ft/FREE_TIME_TAG]...`<br> e.g.`edit 1 n/Alex p/98765432` |
| **Exit**              | `exit`                                                                                                                                                                  |
| **Find**              | `find KEYWORD [MORE_KEYWORDS]...`<br> e.g. `find Alice` <br> *only searches the name                                                                                    |
| **Help**              | `help`                                                                                                                                                                  |
| **List**              | `list`                                                                                                                                                                  |
| **Who Is Free**       | `whoisfree DAY:TIME`<br> e.g. `whoisfree Mon:0800`                                                                                                                      |

---

<div style="page-break-after: always;"></div>

## Format for Fields
| Field           | Format                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Name            | Can only contain alphanumeric characters and spaces in between. <br> e.g. `Dormie Tan`.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| Phone Number    | Must contain only numbers, be 8 digits long, and must start with an 8 or 9.<br> All mobile numbers are assumed to be Singapore numbers, with an area code of (+65). <br> e.g. `91234567`.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| Email           | Must be of the format local-part@domain and adhere to the following constraints:<br> 1. The local-part should only contain alphanumeric characters and the following special character (fullstop): `.` The local-part may not start or end with any special characters.<br> 2. This is followed by a `@` and then a domain name. The domain name is made up of domain labels separated by periods.<br> The domain name must:<br>     - end with a domain label at least 2 characters long<br>     - have each domain label start and end with alphanumeric characters<br>     - have each domain label consist of alphanumeric characters, separated only by periods, if any. <br> Email is case-insensitive. <br> e.g.`dormie@example.com`. |
| Room Number     | {block}-{floor}-{room number}, where block and room number are at least 2 alphanumeric characters and floor is strictly 2 alphanumeric characters. <br> e.g.`nw-12-12`.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| Telegram Handle | Can only contain case-insensitive letters A-Z, digits 0-9, and underscores, with a length between 5 and 32 characters. <br> Note: Do not include the `@` symbol in the input. <br> e.g `dormie_123`.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| Birthday        | `dd/MM/yyyy`, `dd-MM-yyyy`, `yyyy-MM-dd`, `yyyy/MM/dd`. <br> `dd` is the date of the month, `MM` is the month, `YYYY` is the year. <br> e.g. `30/01/2024, 30-01-2024, 2024-01-30, 2024/01/30` all represent 30 January 2024.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| Dorm Tag        | Any non-empty String that contains at least one non-whitespace character. <br> e.g. `PGPR`.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| Free Time Tag   | `DDD:HHmm-HHmm`. <br> `DDD` is from Mon-Sun (case-sensitive), `HHmm` is 24 hour time format. <br> e.g. `Mon:1300-1400`.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| Timestamp       | `DDD:HHmm`. <br> `DDD` is from Mon-Sun (case-sensitive), `HHmm` is 24 hour time format. <br> e.g. `Mon:1300`.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |

---

<div style="page-break-after: always;"></div>

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user. <br> e.g. in `add n/NAME p/PHONE_NUMBER`, `NAME` and `PHONE_NUMBER` are parameters which can be used as `add n/John Doe p/91234567`.
* Items in square brackets are optional. <br> e.g. `add n/NAME p/PHONE_NUMBER [ft/FREE_TIME_TAG]` can be used as `add n/John Doe p/91234567 ft/Mon:1300-1400` or as `add n/John Doe p/91234567`.
* Items with `...` after them can be used 1, or more times in a single command. <br>
If `...` is used after an optional item, it means that the item can be used 0 or more times in a single command. <br> 
e.g. `addTime INDEX ft/FREE_TIME_TAG...` can be used as `addTime 1 ft/Mon:1300-1400` or `addTime 1 ft/Mon:1300-1400 ft/Tue:1400-1600`. <br>
e.g. `edit INDEX [ft/FREE_TIME_TAG]...` can be used as `edit 1 ft/` or `edit 1 ft/Mon:1300-1400 ft/Tue:1400-1600`.
* `INDEX` refers to the index number shown in the displayed person list.
* `INDEX` must be a positive integer. e.g. 1, 2, 3. (Do **not** include the `+` symbol in your command.)
* Parameters can be in any order (except `INDEX`). <br> e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.
* Extraneous parameters for commands that do not take in parameters (such as `list`) will be ignored. <br> e.g. if the command specifies `list 123`, it will be interpreted as `list`.
* Command keywords are case-sensitive. Command keywords for the commands should be exactly the same as demonstration, or else Dormie would not recognize it. <br> e.g. `add` is the command keyword in the add command, where `Add` or `ADD` will not work.
* When a command is invalid or fails, the error message will guide you to a valid command. You may also want to refer to some details of the command in this user guide to help troubleshoot.

</div>

### Adding a person: `add`

Creates a new contact for a person.

Format: `add n/NAME p/PHONE_NUMBER [e/EMAIL] [r/ROOM_NUMBER] [t/TELEGRAM_HANDLE] [b/BIRTHDAY] [d/DORM_TAG] [ft/FREE_TIME_TAG]...`

Examples:
- Adding a person with only mandatory fields: <br> `add n/Alice Lim p/91234567`.
- Adding a person with all mandatory and some optional fields: <br> `add n/John Doe p/98765432 r/sw-01-01 ft/Mon:1300-1400 ft/Tue:1300-1400`.
- Adding a person with all fields: <br> `add n/Jane Doe p/97826712 e/janed@example.com r/sw-02-02 t/janeDoe b/11/11/2001 d/PGPR ft/Mon:1000-1200 ft/Tue:1300-1400`.

### Adding Free Time Tag : `addTime`
Adds 1 or multiple specified `freeTimeTags`

Format: `addTime INDEX ft/FREE_TIME_TAG...`

Examples:
- Single input: `addTime 1 ft/Mon:1300-1400`
- Multiple input: `addTime 1 ft/Mon:1300-1400 ft/Tue:1300-1400`

Note:
- The command will only add the user input free time tags that the specified contact does not have.

### Clearing all persons: `clear`

Clears all person records.

<box type="warning" seamless>
After clearing all records, you will not be able to undo the action!
</box>

### Deleting a person : `delete`

Deletes the specified person from Dormie.

Format: `delete INDEX`

- Deletes the person at the specified INDEX.

Examples:
- `delete 2` deletes the 2nd person in Dormie.

### Deleting Free Time Tag : `deleteTime`
Deletes 1 or multiple specified `freeTimeTags`

Format: `deleteTime INDEX ft/FREE_TIME_TAG...`

Examples:
- Single input: `deleteTime 1 ft/Mon:1300-1400`
- Multiple input: `deleteTime 1 ft/Mon:1300-1400 ft/Tue:1300-1400`

Note:
- The command will only delete the user input free time tags that the specified person has.

### Editing a person : `edit`

Edits the specified fields of an existing person in Dormie.

- Edit function will replace the specified field with the new input.
- Edits the person at the specified INDEX. 
- Existing values will be updated to the input values.
- Minimum 1 field must be specified. e.g. `n/NAME` is a field.

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [r/ROOM_NUMBER] [t/TELEGRAM_HANDLE] [b/BIRTHDAY] [d/DORM_TAG] [ft/FREE_TIME_TAG]...`

Examples:
- `edit 1 n/Alex r/01-05-11` Edits the name and room number of the first person to be Alex and 05-11 respectively.

Note:
- Edit command can be executed on multiple specified `INDEX` when editing `DORM_TAG` or `FREE_TIME_TAG`.
- Edit command can clear all free time tags of the specified contact(s) by leaving it blank after the `ft/` prefix. E.g. `edit 1 ft/` clears all free time tags of the first person.

Examples:
- `edit 1 2 3 d/PGPR` edits the Dorm tags of the first, second and third person to be PGPR.
- `edit 1 2 ft/Mon:1300-1400` edits the free time tags of the first and second person to be Mon:1300-1400.

### Close Dormie : `exit`

Closes the Dormie application.

<div style="page-break-after: always;"></div>

### Filter the contact list by name : `find`

View all contacts whose names contain the user input keyword/s.

Format: `find KEYWORD [MORE_KEYWORDS]...`
- `KEYWORD` is case-insensitive. e.g.`alex` will match `Alex`.
- Order of keywords does not matter. e.g.`Yeoh Alex` will match `Alex Yeoh`.
- Only the names are searched.
- Only full words will be matched. e.g.`Ale` will not match `Alex`.
- Contacts with names that match at least one keyword will be returned. e.g.keyword:`Yeoh` will return `Alex Yeoh`,`Bernice Yeoh`.

Note:
- Every time a `find` command is executed, Dormie displays all matching contacts from the original contact list (i.e., the one before any filtering is applied).
- A common approach to view the original contact list after executing a `find` command is by using the `list` command.

### Provide more detail on existing commands : `help`

Show a link to the User Guide.

### Listing all persons : `list`

List all contacts and their details.

### Checking who is free : `whoisfree`
View all persons that are available on the specified day and time.

Format: `whoisfree DAY:TIME`
   - `DAY` is from Mon-Sun which is case-sensitive.
   - `TIME` is 24-hour time format.

Example:
- `whoisfree Mon:1300` lists all contacts that are free at the specified day and time

Note:
- `TIMESTAMP` in the error message refers to `DAY:TIME`.
- `freeTimeTag` that is on the specified day and ends at the specified time will not be considered as free.
- Example:
   - John is free on `Mon:1200-1300`
   - `whoisfree Mon:1300` will not display John.

### Important Notes
- No 2 people can share the same `PHONE_NUMBER`, `EMAIL`, or  `TELEGRAM_HANDLE`.
- If `freeTimeTags` are edited using the `edit` command, the person's `freeTimeTags` will be replaced with the new set of `freeTimeTags`.
- Example:
   - Let Joe have a `freeTimeTag`:`Mon:1300-1400` and have the index 1:
   - `edit 1 ft/`: Will delete the existing `freeTimeTags`
   - `edit 1 ft/Tue:1300-1400 ft/Wed:1300-1400` Will replace the existing _Monday_ tag with the _Tuesday_ and _Wednesday_ tag.

### Saving the data

Dormie data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

<div style="page-break-after: always;"></div>

### Editing the data file

Dormie data are saved automatically as a JSON file [JAR file location]/data/dormie.json. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

Caution:
If your changes to the data file makes its format invalid, Dormie may discard all data during the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the Dormie to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

### Indicator icons
#### Room Number Outdated 
<img src="images/calendar_alert.png" alt="calendar_alert" width="24"/> 
<br>
Shows up next to a contact when room number might be outdated. If a room number was last updated before the annual room assignments (which occur between April 5th and 12th), the alert appears. When you see this alert, it’s a good idea to check and update the room number if necessary.

#### Birthday
<img src="images/birthday_cake.png" alt="birthday_cake" width="24"/>
<br>
Shows up next to a contact when the contact's birthday is today. If the birthday icon shows up, it might be a good idea to wish your friend "Happy Birthday".

---

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Dormie home folder.

---

<div style="page-break-after: always;"></div>

## Glossary

| Term                                  | Definition, Examples                                                                                                                                                                                                                                                                            |
|---------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Command**                           | Instruction provided by a user to specify the desired action or change to be performed by an application.                                                                                                                                                                                       |
| **Command Line Interface (CLI)**      | Text-based interface used to interact with the application by typing commands into a command box.                                                                                                                                                                                               |
| **Graphical User Interface (GUI)**    | User interface that allows users to interact with graphical icons and visual indicators, use graphical elements such as windows, buttons, menus, and dialog boxes to facilitate user interaction with the application.                                                                          |
| **Home Folder**                       | Main directory or folder where an application is installed or resides. The home folder typically contains the application's executable files, configuration files, and data files.                                                                                                              |
| **JavaScript Object Notation (JSON)** | Lightweight data interchange format that is easy for humans to read and write and easy for machines to parse and generate. JSON is based on key-value pairs and data structures, making it a popular format for representing structured data in web development and other programming contexts. |
| **Java**                              | General-purpose, class-based, object-oriented programming language designed to have as few implementation dependencies as possible. Java is widely used for developing applications, including desktop, web, and mobile applications.                                                           |
| **MacOS**                             | Operating system developed by Apple Inc. for its Macintosh line of computers. MacOS is known for its user-friendly interface, stability, and security features.                                                                                                                                 |
| **Parameter**                         | Value that is passed to a command to specify the desired action or behavior. Parameters are used to customize the behavior of commands based on user input.                                                                                                                                     |
| **Portable Document Format (PDF)**    | File format created by Adobe that gives people an easy, reliable way to present and exchange documents.                                                                                                                                                                                         |
| **Terminal**                          | Command-line interface used to interact with the operating system by typing commands. The terminal allows users to execute commands, run scripts, and perform various system tasks.                                                                                                             |
| **Windows**                           | Operating system developed by Microsoft Corporation for personal computers. Windows is known for its graphical user interface, multitasking capabilities, and compatibility with a wide range of software applications.                                                                         |
