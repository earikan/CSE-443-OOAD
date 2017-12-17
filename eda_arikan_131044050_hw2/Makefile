JFLAGS = -g -Xlint:unchecked
JC = javac 
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	TransformWithHook.java \
	TransformDFT.java \
	TransformDCT.java \
	Transform.java
	

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
