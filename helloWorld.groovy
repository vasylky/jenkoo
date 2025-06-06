pipelineJob('hello-pipeline-job') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/vasylky/jenkoo.git')
                    }
                    branch('main')
                }
            }
            scriptPath('helloWorld.jenkinsfile')  
        }
    }
}
