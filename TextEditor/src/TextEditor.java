import java.util.Stack;

public class TextEditor {
    private StringBuilder currentText;
    private final Stack<String> undoStack;
    private final Stack<String> redoStack;

    public TextEditor() {
        currentText = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void show() {
        System.out.println(currentText.toString());
    }

    public void write(String text) {
        undoStack.push(currentText.toString());
        currentText.append(text);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText.toString());
            currentText = new StringBuilder(undoStack.pop());
        } else {
            System.out.println("Tidak ada yang bisa di-undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText.toString());
            currentText = new StringBuilder(redoStack.pop());
        } else {
            System.out.println("Tidak ada yang bisa di-redo.");
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.write("Selamat datang ");
        editor.write("di dunia perograman.");
        editor.show();

        editor.undo();
        editor.show();

        editor.redo();
        editor.show();

        editor.write(" Semoga sukses!");
        editor.show();

        editor.undo();
        editor.show();
    }
}