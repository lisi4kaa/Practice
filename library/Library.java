import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Library {
	private List<Book> books = new ArrayList<>();
	private List<Reader> readers = new ArrayList<>();
	private Map<Reader,List<Book>> issuedBooks = new HashMap<>();
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void addReader(Reader reader) {
		readers.add(reader);
	}
	
	public boolean issueBook(Reader reader, Book book) {
		if(!book.isAvailable()) {
			return false;
		}
		
		book.setAvailable(false);
		issuedBooks.computeIfAbsent(reader, r -> new ArrayList<>()).add(book);
		return true;
	}
	
	public List<Book> getBooksIssuedToReader(Reader reader) {
        return issuedBooks.getOrDefault(reader, Collections.emptyList());
    }
	
	public Reader getMostActiveReader() {
        return issuedBooks.entrySet().stream()
            .max(Comparator.comparingInt(e -> e.getValue().size()))
            .map(Map.Entry::getKey)
            .orElse(null);
    }
	
	public Set<String> getUniqueGenres() {
        return books.stream()
            .map(Book::getGenre)
            .collect(Collectors.toSet());
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
            .filter(b -> b.getAuthor().equalsIgnoreCase(author))
            .collect(Collectors.toList());
    }

    public List<Reader> getDebtors() {
        return issuedBooks.entrySet().stream()
            .filter(e -> e.getValue().stream().anyMatch(b -> !b.isAvailable()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    public void saveDebtorsToFile(String filename) {
        List<Reader> debtors = getDebtors();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Reader r : debtors) {
                writer.write(r.getName() + " - " + r.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
