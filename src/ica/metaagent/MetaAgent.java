package ica.metaagent;

import ica.messages.Message;

/**
 * This is the abstract super class for all meta agents with classes that are
 * used through but should not be called directly.
 *
 * @author v8036651
 */
public abstract class MetaAgent {

    protected final String name;

    /**
     * Constructor for a new MetaAgent, this constructor should never be called
     * directly.
     *
     * @param name the name of the node to be created
     * @author v8036651
     */
    MetaAgent(String name) {
        if (!usernameValidation(name)) {
            throw new IllegalArgumentException("Invalid user name");
        }
        this.name = name;
    }

    /**
     * Used to return the name value of a MetaAgent.
     *
     * @return String of the name of the MetaAgent
     * @author v8036651
     */
    public String getName() {
        return name;
    }

    /**
     * Abstract method that is overwritten by subclasses for handling a message.
     *
     * @param agent source of the message which is being sent
     * @param msg the message which is being sent
     * @author v8036651
     */
    public abstract void messageHandler(MetaAgent agent, Message msg);

    /**
     * Validates whether the user name is allowed
     *
     * @param name metaAgent name to be used
     * @return true if metaAgent name allowed
     * @author v8243060
     */
    protected boolean usernameValidation(String name) {
        return (name != null && !name.contains("/") && !name.equalsIgnoreCase("global"));
    }
}
