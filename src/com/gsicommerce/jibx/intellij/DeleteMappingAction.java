package com.gsicommerce.jibx.intellij;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;

/**
 * @author brodericke
 */
public class DeleteMappingAction extends AnAction {

    public void actionPerformed(AnActionEvent event) {
        PsiFile psiBinding = event.getData(LangDataKeys.PSI_FILE);
        Module module = event.getData(LangDataKeys.MODULE);
        if (psiBinding == null)
            return;
        VirtualFile binding = psiBinding.getVirtualFile();
        if (binding == null)
            return;
        assert module != null : "The current module should not be null!";
        BindingCompilerModuleComponent compiler = module.getComponent(BindingCompilerModuleComponent.class);
        compiler.removeBinding(binding);

        System.out.println("removed jibx binding: " + binding.getPath());
    }
}
