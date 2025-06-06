pipelineJob('MyProjectPipeline') {
    description('Pipeline for MyProject')
    parameters {
        stringParam('PROJECT_NAME', 'MyProject', 'Name of the project')
        stringParam('VERSION', '1.0.0', 'Version of the project')
        choiceParam('BRANCH_NAME', ['main', 'feature/test'], 'Git branch to build')
    }
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/vasylky/jenkoo.git')
                    }
                    branch('${BRANCH_NAME}')
                }
                scriptPath('helloWorld.jenkinsfile')
            }
        }
    }
}