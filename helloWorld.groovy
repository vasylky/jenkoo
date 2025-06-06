jobDsl {
    pipelineJob('MyProjectPipeline') {
        description('Pipeline for MyProject')
        parameters {
            stringParam('PROJECT_NAME', 'MyProject', 'Name of the project')
            stringParam('VERSION', '1.0.0', 'Version of the project')
        }
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url('https://github.com/vasylky/jenkoo.git')
                            branch('main')
                        }
                    }
                    scriptPath('Jenkinsfile')
                }
            }
        }
    }
}