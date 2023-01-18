## Requirements
 * scala-cli
 * jvm or lvm stuff around

## Compile & Run

 * For `jvm`:
   ```
   > scala-cli .
   # OR
   > scala-cli . --platform jvm
   ```

 * For `native`:
   ```
   > scala-cli . --platform native
   ```

Then `curl http://localhost:8080/hello/world`.