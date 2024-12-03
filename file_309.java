    protected void readLineByLine() {
        String line;
        try {
            while ((line = data.readLine()) != null) {
                //System.out.println(line);
                ObjectNode interaction = (ObjectNode) DataSiftClient.MAPPER.readTree(line);
                send(new Interaction(interaction));
            }
            buffer.discardReadBytes();
        } catch (IOException e) {
            log.info("Failed to decode interaction ", e);
        }
    }