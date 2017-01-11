xlr {
    release("Full blown release") {
        description "Sample template created from Groovy DSL"
        variables {
            stringVariable("testVar")
        }
        phases {
            phase("Example") {
                tasks {
                    notification('notification task') {
                        description "notification task"
                        addresses "mail1@mail.com", "mail2@mail.com"
                        subject "my subject"
                        body "my notification body"
                    }
                    userInput('userInput task') {
                        description "userInput task"
                        variables {
                            variable("testVar")
                        }
                    }
                }
            }
        }
    }
}
