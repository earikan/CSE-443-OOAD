JFLAGS = -g -Xlint:unchecked
JC = javac 
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Snake.java \
	CharacterDecorator.java \
	ForeignLanguages.java \
	Internship.java \
	Python.java \
	Anaconda.java \
	RandomFoodTimer.java \
	RandomJobOfferTimer.java \
	StaminaTimer.java \
	TraininCertificates.java \
	Board.java \
	SnakeGame.java




default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
