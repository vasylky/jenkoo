pipelineJob('hello-world-job') {
    description('Проста hello world pipeline job')
    
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/your-username/pipeline-repo.git')
                    }
                    branch('main')
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}
