Topics:
● Relationships

● Validations

● Domain Models

● JPA methods

Tasks:
● Have the question dashboard display each question and their tags.

● Allow users to create questions with tags and implement validation errors.

● Allow users to answer questions and implement validation errors.

● Have the question show page display all the answers for that specific questions.

CategoryRepository
Some derived queries you may need to get you started..

    // Retrieves a list of all categories for a particular product
    List<category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<category> findByProductsNotContains(Product product);
Note: No Middle Model Needed
For this assignment you need only implement two models: Product and Category. Since there is no extra data required for the relationship, you do not need a middle model, that is, you do not need a class to handle the joiner table in the database.

Topics:
● Many-to-Many relationships

● JPA methods

Tasks:
● Allow users to create a product.

● Allow users to create a new category.

● In the products show page, allow users to add a category to a specific product.

● In the categories show page, allow users to add a product to a specific category


The product show page should only have categories that the current product does not already belong to. Once a category is added, it should append to the list of categories.

The category show page should only have products that the current category does not already belong to. Once a product is added, it should append to the list of products.