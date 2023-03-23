package exercise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String soursPath1, String soursPath2, String finalPath3) {

        CompletableFuture<String> futurePath1 = CompletableFuture.supplyAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            try {
                return Files.readString(Path.of(soursPath1).toAbsolutePath().normalize());
            } catch (IOException e) {
                    throw new RuntimeException(e);
            }
        });


        CompletableFuture<String> futurePath2 = CompletableFuture.supplyAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            try {
                return Files.readString(Path.of(soursPath2).toAbsolutePath().normalize());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        CompletableFuture<String> futurePath3 = futurePath1.thenCombine(futurePath2, (fileRead1, fileRead2) -> {

            try(FileOutputStream fos=new FileOutputStream(finalPath3))
            {
                var text = fileRead1 + fileRead2;
                byte[] buffer = text.getBytes();

                fos.write(buffer, 0, buffer.length);

            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
            return finalPath3;

        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });

        return futurePath3;
    }

    public static CompletableFuture<Long> getDirectorySize(String path) {

        return CompletableFuture.supplyAsync(() -> {
            Long size;
            try {
                size = Files.walk(Path.of(path).toAbsolutePath().normalize(), 1)
                    .filter(Files::isRegularFile)
                    .mapToLong(p -> {
                        try {
                            return Files.size(p);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .sum();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return size;

        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = App.unionFiles(
            "src/main/resources/file1.txt",
            "src/main/resources/file2.txt",
            "src/main/resources/file3.txt"
        );
        result.get();
        CompletableFuture<Long> size = getDirectorySize("src/main/resources");
        size.get();
        // END
    }
}

