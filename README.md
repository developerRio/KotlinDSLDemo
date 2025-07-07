# 🧩 KList DSL — Jetpack Compose Fluent List Builder

A **declarative, fluent Kotlin DSL** for building scalable, dynamic list-based UIs in **Jetpack Compose** — inspired by the `Modifier` chaining pattern and designed for reusability, modularity, and extensibility.

---

## ✨ Features

- ✅ Fluent `KList` DSL style  
- ✅ Supports headers, text, images (including network via Coil), buttons, and text fields  
- ✅ Built-in `LazyColumn` rendering  
- ✅ Item animation support via `animateItemPlacement()`  
- ✅ Optional dividers between items  
- ✅ Clean architecture with sealed class modeling  
- ✅ Ready for Kotlin Multiplatform (KMM) shared modules

---

## 📦 Project Structure
ui/component/
 KList.kt              // Entry point DSL
 KListBuilder.kt       // DSL builder and chain functions
 KListItem.kt          // Sealed class list item types
 KListRenderer.kt      // LazyColumn renderer
 KListRenderItem.kt    // Internal item Composable

## 🚀 Usage Example

```kotlin
@Composable
fun MyKListDemo(innerPadding: PaddingValues) {
    val context = LocalContext.current
    val painter = rememberAsyncImagePainter("https://cryptologos.cc/logos/bitcoin-btc-logo.png")

    Column(modifier = Modifier.padding(innerPadding)) {
        KList {
            space(16.dp)
            header("KList DSL Demo")
            text("This image is loaded from the internet")
            image(painter)
            textField(id = "username", hint = "Enter Username") {
                Toast.makeText(context, "Typed: $it", Toast.LENGTH_SHORT).show()
            }
            button("Submit") {
                Toast.makeText(context, "Button clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

KList {
    space(height: Dp)
    header(text: String)
    text(text: String)
    image(painter: Painter)
    textField(id: String, hint: String, onValueChanged: (String) -> Unit)
    button(text: String, onClick: () -> Unit)
}
```

## Evaluation Goals (Assignment)


| Criteria                        | Status |
| ------------------------------- | ------ |
| Clean, modular, and scalable    | ✅      |
| Compose feature usage           | ✅      |
| Fluent DSL/API design           | ✅      |
| Reusability and maintainability | ✅      |
| Optional creative enhancements  | ✅      |




