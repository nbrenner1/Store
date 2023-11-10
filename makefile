#makefile for custom store

all: store

store:
	javac store.java user.java customer.java admin.java product.java cartitem.java inventory.java shoppingcart.java filemanager.java main.java

run:
	java main

clean:
	rm *.class
