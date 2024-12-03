    private void initEmptyArray() {
        String[] emptyArray = {};
        spinner7 = findViewById(R.id.spinner7);
        spinner7.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, emptyArray));
    }