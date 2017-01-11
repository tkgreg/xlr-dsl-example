xlr {
  release("Full blown release") {
    description "Sample template created from Groovy DSL"
    variables {
      stringVariable("testVar")
    }
    phases {
      phase("First round") {
        tasks {
          task {
            type "xlrelease.ScriptTask"
            title "script task"
            description "dynamic script task"
            script "println 'hello world'"
          }
          manual("manual task") {
            description "manual task"
          }
          createRelease('createRelease task') {
            description "createRelease task"
            newReleaseTitle "title of the new release"
            startRelease false
            template "Container folder/Sub folder/Template 1" // can be path OR Id
            releaseTags "tag1", "tag2", "tag2"
          }
          gate('gate task') {
            description 'gate task'
            conditions {
              condition("my condition 1")
              condition("my condition 2")
            }
            dependencies {
              dependency {
                variable 'customVar' // NOTE : Do not use dollar{} syntax here as it would be interpolated by XLR
              }
              dependency {
                target {
                  release "my release"
                  phase "my phase"
                  task "my task"
                }
              }
            }
          }
        }
      }
      phase("second round") {
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