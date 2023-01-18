# Description

Demo for using http4s server.  
For build uses scala-cli.  
Has fs2, cats, cats-effect as libs available.  
Compiles and runs on both native and jvm.

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

# License

This is just a template/example, so most permissible possible is applied.
All files and things here should be considered **CC0**.