pipelineJob('example-job') {
    parameters {
        stringParam('GREETING', 'Hello, Jenkins!', 'Повідомлення для виводу')
    }
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/your-repo.git')
                    }
                    branch('main')
                }
            }
            scriptPath('helloWorld.jenkinsfile')
        }
    }
}
